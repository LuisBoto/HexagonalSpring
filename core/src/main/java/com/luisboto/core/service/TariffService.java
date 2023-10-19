package com.luisboto.core.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.luisboto.core.adapter.TariffAdapter;
import com.luisboto.core.model.Tariff;

@Service
public class TariffService {
	
	private TariffAdapter tariffAdapter;
	
	public TariffService(TariffAdapter tariffAdapter) {
		this.tariffAdapter = tariffAdapter;
	}
	
	public Tariff getActiveTariff(String productId, String brandId, Date applicationDate) {
		return this.tariffAdapter.findActiveTariffByProductBrandAndDate(productId, brandId, applicationDate);
	}

}
