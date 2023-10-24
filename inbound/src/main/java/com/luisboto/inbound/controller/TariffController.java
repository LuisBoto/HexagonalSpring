package com.luisboto.inbound.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luisboto.core.ports.in.TariffServicePortIn;
import com.luisboto.inbound.dto.TariffDto;

@RestController
@RequestMapping("/api/v1")
public class TariffController {

	private TariffServicePortIn tariffService;

	public TariffController(TariffServicePortIn tariffService) {
		this.tariffService = tariffService;
	}

	@GetMapping("/tariff")
	public ResponseEntity<TariffDto> getActiveTariff(@RequestParam String productId, @RequestParam String brandId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

		return ResponseEntity.ok(
				TariffDto.toDto(
						tariffService.getActiveTariff(productId, brandId, applicationDate)));

	}

}
