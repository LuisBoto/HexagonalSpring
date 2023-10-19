package com.luisboto.core.model;

import java.math.BigDecimal;
import java.util.Date;

public class Tariff {

	private String productId;
	private String brandId;
	private Date startDate;
	private Date endDate;
	private BigDecimal price;
	private String currency;
	private int priority;

	public Tariff(String productId, String brandId, Date startDate, Date endDate, BigDecimal price, String currency, int priority) {
		this.productId = productId;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.currency = currency;
		this.priority = priority;
	}

	public String getProductId() {
		return productId;
	}

	public String getBrandId() {
		return brandId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
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
