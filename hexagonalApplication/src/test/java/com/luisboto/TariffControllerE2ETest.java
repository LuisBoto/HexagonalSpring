package com.luisboto;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.luisboto.inbound.dto.TariffDto;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TariffControllerE2ETest {
	
	private static final String BASE_URL = "/api/v1/tariff";
	private static final TariffDto TARIFF_1 = new TariffDto("1", "35455", "1", LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), BigDecimal.valueOf(35.50));
	private static final TariffDto TARIFF_2 = new TariffDto("2", "35455", "1", LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"), BigDecimal.valueOf(25.45));
	private static final TariffDto TARIFF_3 = new TariffDto("3", "35455", "1", LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"), BigDecimal.valueOf(30.50));
	private static final TariffDto TARIFF_4 = new TariffDto("4", "35455", "1", LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), BigDecimal.valueOf(38.95));
	
	
	@LocalServerPort
    int port;
	
	@BeforeEach
	public void setUp() {
		RestAssured.port = port;
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "http://localhost:"+port;
	}
	
	private static Object[] requestAndResponseTestParameters()
	{
	    return new Object[] {
	        new Object[]{"35455", "1", "2020-06-14T10:00:00", TARIFF_1},
	        new Object[]{"35455", "1", "2020-06-14T16:00:00", TARIFF_2},
	        new Object[]{"35455", "1", "2020-06-14T21:00:00", TARIFF_1},
	        new Object[]{"35455", "1", "2020-06-15T10:00:00", TARIFF_3},
	        new Object[]{"35455", "1", "2020-06-16T21:00:00", TARIFF_4},
	    };
	}
	
	@ParameterizedTest
	@MethodSource("requestAndResponseTestParameters")
	public void givenCertainDate_whenRequestActiveTariff_thenCorrectPriorityTariff(String productId, String brandId, String appliedDate, TariffDto tariff) {
		given()
			.contentType("application/json")
			.queryParam("productId", productId)
			.queryParam("brandId", brandId)
			.queryParam("applicationDate", appliedDate)
		.when()
			.get(BASE_URL)
		.then()
			.statusCode(200)
			.body(
					"priceList", equalTo(tariff.getPriceList()),
					"productId", equalTo(tariff.getProductId()),
					"brandId", equalTo(tariff.getBrandId()),
					"startDate", equalTo(this.toFullFormatDateString(tariff.getStartDate())),
					"endDate", equalTo(this.toFullFormatDateString(tariff.getEndDate())),
					"price", equalTo(tariff.getPrice().floatValue())
			);
	}
	
	@Test
	public void givenOldDateParameters_whenRequestTariff_thenNoTariffIsFound() {
		given()
			.contentType("application/json")
			.queryParam("productId", "35455")
			.queryParam("brandId", "1")
			.queryParam("applicationDate", "2000-01-10T10:00")
		.when()
			.get(BASE_URL)
		.then()
			.statusCode(404)
			.body(
					"status", equalTo("NOT_FOUND"),
					"message", equalTo("No active tariff found for product 35455 on brand 1 for date 2000-01-10T10:00")
			);
	}
	
	private String toFullFormatDateString(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		return date.format(formatter);
	}
	
}
