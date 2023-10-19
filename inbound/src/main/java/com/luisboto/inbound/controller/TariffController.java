package com.luisboto.inbound.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisboto.core.service.TariffService;

@RestController
@RequestMapping("/api/v1")
public class TariffController {
	
	private TariffService tariffService;
	
	public TariffController(TariffService tariffService) {
		this.tariffService = tariffService;
	}

	@GetMapping("/tariff")
	public void getActiveTariff() {
		tariffService.getActiveTariff();
	}


}
