package com.luisboto.core.adapter;

import java.util.Date;

import com.luisboto.core.model.Tariff;

public interface TariffAdapter {
	
	abstract public Tariff findActiveTariffByProductBrandAndDate(String productId, String brandId, Date applicationDate);

}
