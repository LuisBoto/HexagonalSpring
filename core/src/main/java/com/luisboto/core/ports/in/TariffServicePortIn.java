package com.luisboto.core.ports.in;

import java.time.LocalDateTime;

import com.luisboto.core.model.Tariff;

public interface TariffServicePortIn {
	
	public abstract Tariff getActiveTariff(String productId, String brandId, LocalDateTime applicationDate);

}
