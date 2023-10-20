package com.luisboto.inbound.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.luisboto.core.model.Tariff;

public class TariffDto {

	private String priceList;
	private String productId;
	private String brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
	private String currency;
	private int priority;

	public TariffDto(String priceList, String productId, String brandId, LocalDateTime startDate, LocalDateTime endDate, BigDecimal price, String currency, int priority) {
		this.priceList = priceList;
		this.productId = productId;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.currency = currency;
		this.priority = priority;
	}

	public String getPriceList() {
		return this.priceList;
	}
	
	public String getProductId() {
		return productId;
	}

	public String getBrandId() {
		return brandId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

	public int getPriority() {
		return priority;
	}
	
	public static TariffDto toDto(Tariff tariff) {
		return new TariffDto(
				tariff.getPriceList(),
				tariff.getProductId(),
				tariff.getBrandId(),
				tariff.getStartDate(),
				tariff.getEndDate(),
				tariff.getPrice(),
				tariff.getCurrency(),
				tariff.getPriority()
				);
	}

}
