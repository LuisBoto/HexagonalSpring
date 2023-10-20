package com.luisboto.outbound.provider;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.luisboto.core.adapter.TariffAdapter;
import com.luisboto.core.model.Tariff;
import com.luisboto.outbound.entity.TariffEntity;
import com.luisboto.outbound.repository.TariffRepository;

@Component
public class TariffProvider implements TariffAdapter {
	
	private TariffRepository tariffRepository;
	
	public TariffProvider(TariffRepository tariffRepository) {
		this.tariffRepository = tariffRepository;
	}

	@Override
	public Tariff findActiveTariffByProductBrandAndDate(String productId, String brandId, LocalDateTime applicationDate) {
		return TariffEntity.toModel(
				this.tariffRepository.findActiveTariffByProductBrandAndDate(productId, brandId, applicationDate));
	}

}
