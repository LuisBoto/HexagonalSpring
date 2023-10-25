package com.luisboto.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.luisboto.core.exception.NoActiveTariffFoundException;
import com.luisboto.core.model.Tariff;
import com.luisboto.core.ports.out.TariffAdapter;

class TariffServiceTest {
	
	@Test
	void givenCorrectParameters_whenRequestActiveTariff_thenReturnsTariffModel() {
		LocalDateTime date = LocalDateTime.now();	
		Tariff result = new Tariff("1", "2", "3", date, date, BigDecimal.TEN, "EUR", 1);
		TariffAdapter mockTariffAdapter = Mockito.mock(TariffAdapter.class);
		when(mockTariffAdapter.findActiveTariffByProductBrandAndDate("10", "5", date)).thenReturn(result);
		
		TariffService sut = new TariffService(mockTariffAdapter);
		assertEquals(result, sut.getActiveTariff("10", "5", date));
	}
	
	@Test
	void givenNoTariff_whenRequestActiveTariff_thenThrowNoActiveTariffException() {
		LocalDateTime date = LocalDateTime.now();	
		TariffAdapter mockTariffAdapter = Mockito.mock(TariffAdapter.class);
		when(mockTariffAdapter.findActiveTariffByProductBrandAndDate("10", "5", date)).thenReturn(null);
		
		TariffService sut = new TariffService(mockTariffAdapter);
		assertThrows(NoActiveTariffFoundException.class, () -> sut.getActiveTariff("10", "5", date));
	}

}
