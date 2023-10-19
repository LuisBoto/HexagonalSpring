package com.luisboto.inbound.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luisboto.core.service.TariffService;
import com.luisboto.inbound.dto.TariffDto;

@RestController
@RequestMapping("/api/v1")
public class TariffController {
	
	private TariffService tariffService;
	
	public TariffController(TariffService tariffService) {
		this.tariffService = tariffService;
	}

	@GetMapping("/tariff")
	public TariffDto getActiveTariff(
			@RequestParam String productId,
			@RequestParam String brandId,
			@RequestParam @DateTimeFormat(pattern="dd/MM/yyyy") Date applicationDate
	) {
		return TariffDto.toDto(
				tariffService.getActiveTariff(productId, brandId, applicationDate));
	}


}
