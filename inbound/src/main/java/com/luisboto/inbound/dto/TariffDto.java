package com.luisboto.inbound.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TariffDto {

	private String priceList;
	private String productId;
	private String brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;

	public TariffDto(String priceList, String productId, String brandId, LocalDateTime startDate, LocalDateTime endDate, BigDecimal price) {
		this.priceList = priceList;
		this.productId = productId;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
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

}
