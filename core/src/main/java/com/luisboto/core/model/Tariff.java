package com.luisboto.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Tariff {

	private String priceList;
	private String productId;
	private String brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
	private String currency;
	private int priority;

	public Tariff(String priceList, String productId, String brandId, LocalDateTime startDate, LocalDateTime endDate, BigDecimal price, String currency, int priority) {
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
}
