package com.luisboto.outbound.mapper;

import com.luisboto.core.model.Tariff;
import com.luisboto.outbound.entity.TariffEntity;

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
