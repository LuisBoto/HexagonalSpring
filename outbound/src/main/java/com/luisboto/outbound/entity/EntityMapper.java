package com.luisboto.outbound.entity;

import com.luisboto.core.model.Tariff;

public class EntityMapper {
	
	static public Tariff toModel(TariffEntity tariffEntity) {
		return new Tariff(
				tariffEntity.getPriceList(), 
				tariffEntity.getProductId(), 
				tariffEntity.getBrandId(),
				tariffEntity.getStartDate(), 
				tariffEntity.getEndDate(), 
				tariffEntity.getPrice(),
				tariffEntity.getCurrency(), 
				tariffEntity.getPriority());
	}
	
}
