package com.luisboto.outbound.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.luisboto.core.model.Tariff;
import com.luisboto.outbound.entity.TariffEntity;
import com.luisboto.outbound.repository.TariffRepository;

public class TariffProviderTest {

	@Test
	public void givenCorrectParameters_whenRequestActiveTariff_thenProviderReturnsModel() {
		TariffEntity entity = new TariffEntity("1", "2", "3", LocalDateTime.now(), LocalDateTime.now(), BigDecimal.TEN,"EUR", 3);
		LocalDateTime date = LocalDateTime.now();
		TariffRepository repository = mock(TariffRepository.class);
		when(repository.findActiveTariffByProductBrandAndDate("1", "2", date)).thenReturn(entity);
		TariffProvider sut = new TariffProvider(repository);
		
		Tariff result = sut.findActiveTariffByProductBrandAndDate("1", "2", date);
		
		assertEquals(entity.getPriceList(), result.getPriceList());
		assertEquals(entity.getProductId(), result.getProductId());
		assertEquals(entity.getBrandId(), result.getBrandId());
		assertEquals(entity.getStartDate(), result.getStartDate());
		assertEquals(entity.getEndDate(), result.getEndDate());
		assertEquals(entity.getPrice(), result.getPrice());
		assertEquals(entity.getCurrency(), result.getCurrency());
		assertEquals(entity.getPriority(), result.getPriority());
	}
	
	@Test
	public void givenParametersForNoTariff_whenRequestActiveTariff_thenReturnsNull() {		
		LocalDateTime date = LocalDateTime.now();
		TariffRepository repository = mock(TariffRepository.class);
		when(repository.findActiveTariffByProductBrandAndDate("1", "2", date)).thenReturn(null);
		TariffProvider sut = new TariffProvider(repository);
		
		Tariff result = sut.findActiveTariffByProductBrandAndDate("1", "2", date);
		
		assertNull(result);
	}

}
