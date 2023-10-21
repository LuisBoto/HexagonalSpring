package com.luisboto.outbound.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.luisboto.core.model.Tariff;

public class TariffEntityTest {
	
	@Test
	public void givenTariffEntity_whenConvertToModel_thenFieldsHaveCorrectValues() {
		TariffEntity entity = new TariffEntity("1", "2", "3", LocalDateTime.now(), LocalDateTime.now(), BigDecimal.TEN, "EUR", 3);
		Tariff sut = TariffEntity.toModel(entity);
		
		assertEquals(entity.getPriceList(), sut.getPriceList());
		assertEquals(entity.getProductId(), sut.getProductId());
		assertEquals(entity.getBrandId(), sut.getBrandId());
		assertEquals(entity.getStartDate(), sut.getStartDate());
		assertEquals(entity.getEndDate(), sut.getEndDate());
		assertEquals(entity.getPrice(), sut.getPrice());
		assertEquals(entity.getCurrency(), sut.getCurrency());
		assertEquals(entity.getPriority(), sut.getPriority());
	}

}
