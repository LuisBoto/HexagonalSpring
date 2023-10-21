package com.luisboto.outbound.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import com.luisboto.core.model.Tariff;
import com.luisboto.outbound.data.DataLoader;
import com.luisboto.outbound.repository.TariffRepository;

@DataJpaTest
@ContextConfiguration(classes = { TariffProvider.class, TariffRepository.class, DataLoader.class})
@EnableJpaRepositories(basePackages = {"com.luisboto.outbound.repository"})
@EntityScan("com.luisboto.outbound.entity")
public class TariffProviderIT {

	@Autowired
	private TariffProvider sut;

	@Test
	public void givenDateForSingleTariff_whenRequestActiveTariff_thenReturnsPriority0Tariff() {
		Tariff result = sut.findActiveTariffByProductBrandAndDate("35455", "1", LocalDateTime.parse("2020-06-14T10:00:00"));
		
		assertEquals("1", result.getBrandId());
		assertEquals("35455", result.getProductId());
		assertEquals("1", result.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T00:00:00"), result.getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), result.getEndDate());
		assertEquals("35.50", result.getPrice().toString());
		assertEquals("EUR", result.getCurrency());
		assertEquals(0, result.getPriority());
	}
	
	@Test
	public void givenNoTariffForParameters_whenRequestActiveTariff_thenReturnNull() {
		Tariff result = sut.findActiveTariffByProductBrandAndDate("35455", "1", LocalDateTime.parse("1999-11-30T00:00:00"));
		
		assertNull(result);
	}

}
