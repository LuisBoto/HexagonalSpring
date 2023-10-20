package com.luisboto.core.exception;

import java.time.LocalDateTime;

public class NoActiveTariffFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 7716488870340129611L;

	public NoActiveTariffFoundException(String productId, String brandId, LocalDateTime appliedDate) {
		super(String.format("No active tariff found for product %s on brand %s for date %s",
				productId, brandId, appliedDate.toString()));
	}

}
