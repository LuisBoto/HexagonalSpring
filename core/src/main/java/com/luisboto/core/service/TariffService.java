package com.luisboto.core.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.luisboto.core.adapter.TariffAdapter;
import com.luisboto.core.exception.NoActiveTariffFoundException;
import com.luisboto.core.model.Tariff;

@Service
public class TariffService {
	
	private TariffAdapter tariffAdapter;
	
	public TariffService(TariffAdapter tariffAdapter) {
		this.tariffAdapter = tariffAdapter;
	}
	
	public Tariff getActiveTariff(String productId, String brandId, LocalDateTime applicationDate) {
		
		Tariff result = this.tariffAdapter.findActiveTariffByProductBrandAndDate(productId, brandId, applicationDate);
		if (result == null)
			throw new NoActiveTariffFoundException(productId, brandId, applicationDate);
		return result;
	}

}
