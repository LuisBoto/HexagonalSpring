package com.luisboto.inbound.dto;

import com.luisboto.core.model.Tariff;

public class DtoMapper {

	public static TariffDto toDto(Tariff tariff) {
		return new TariffDto(
				tariff.getPriceList(),
				tariff.getProductId(),
				tariff.getBrandId(),
				tariff.getStartDate(),
				tariff.getEndDate(),
				tariff.getPrice()
				);
	}
	
}
