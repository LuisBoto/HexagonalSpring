package com.luisboto;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.luisboto.inbound.dto.TariffDto;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TariffControllerE2ETest {
	
	private static final String BASE_URL = "/api/v1/tariff";
	private static final TariffDto TARIFF_1 = new TariffDto("1", "35455", "1", LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), BigDecimal.valueOf(35.50));
	
	@LocalServerPort
    int port;
	
	@BeforeEach
	public void setUp() {
		RestAssured.port = port;
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "http://localhost:"+port;
	}
	
	@Test
	public void given10amOn14th_whenRequestActiveTariff_thenIsLowPriority() {
		given()
			.contentType("application/json")
			.queryParam("productId", "35455")
			.queryParam("brandId", "1")
			.queryParam("applicationDate", "2020-06-14T10:00:00")
		.when()
			.get(BASE_URL)
		.then()
			.statusCode(200)
			.body(
					"priceList", equalTo(TARIFF_1.getPriceList()),
					"productId", equalTo(TARIFF_1.getProductId()),
					"brandId", equalTo(TARIFF_1.getBrandId()),
					"startDate", equalTo(this.toFullFormatDateString(TARIFF_1.getStartDate())),
					"endDate", equalTo(TARIFF_1.getEndDate().toString()),
					"price", equalTo(TARIFF_1.getPrice().floatValue())
			);
	}
	
	private String toFullFormatDateString(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		return date.format(formatter);
	}
	
}
