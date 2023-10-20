package com.luisboto.outbound.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.luisboto.outbound.entity.TariffEntity;
import com.luisboto.outbound.repository.TariffRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	private TariffRepository tariffRepository;
	
	public DataLoader(TariffRepository tariffRepository) {
		this.tariffRepository = tariffRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		TariffEntity tariff1 = new TariffEntity("1", "35455", "1", LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), BigDecimal.valueOf(35.50), "EUR", 0);
		TariffEntity tariff2 = new TariffEntity("2", "35455", "1", LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"), BigDecimal.valueOf(25.45), "EUR", 1);
		TariffEntity tariff3 = new TariffEntity("3", "35455", "1", LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"), BigDecimal.valueOf(30.50), "EUR", 1);
		TariffEntity tariff4 = new TariffEntity("4", "35455", "1", LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), BigDecimal.valueOf(38.95), "EUR", 1);

		
		this.tariffRepository.saveAll(Arrays.asList(tariff1, tariff2, tariff3, tariff4));
	}}
