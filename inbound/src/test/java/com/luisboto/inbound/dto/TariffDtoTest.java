package com.luisboto.inbound.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import com.luisboto.core.model.Tariff;

public class TariffDtoTest {
	
	@Test
	public void givenTariffObject_whenConvertToDto_AllPropertiesAreCorrect() {
		Tariff tariffModel = new Tariff("1", "35455", "10", LocalDateTime.now(), LocalDateTime.now(), BigDecimal.TEN, "EUR", 3);
		TariffDto sut = TariffDto.toDto(tariffModel);
		
		assertEquals(tariffModel.getPriceList(), sut.getPriceList());
		assertEquals(tariffModel.getProductId(), sut.getProductId());
		assertEquals(tariffModel.getBrandId(), sut.getBrandId());
		assertEquals(tariffModel.getStartDate(), sut.getStartDate());
		assertEquals(tariffModel.getEndDate(), sut.getEndDate());
		assertEquals(tariffModel.getPrice(), sut.getPrice());
	}

}
