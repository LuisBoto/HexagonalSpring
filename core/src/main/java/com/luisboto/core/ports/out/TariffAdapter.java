package com.luisboto.core.ports.out;

import java.time.LocalDateTime;

import com.luisboto.core.model.Tariff;

public interface TariffAdapter {
	
	abstract public Tariff findActiveTariffByProductBrandAndDate(String productId, String brandId, LocalDateTime applicationDate);

}
