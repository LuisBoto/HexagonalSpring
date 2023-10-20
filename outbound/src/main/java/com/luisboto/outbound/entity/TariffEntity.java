package com.luisboto.outbound.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.luisboto.core.model.Tariff;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "prices")
public class TariffEntity {

	@Id
	@Column(name = "id")
	private String priceList;

	@Nonnull
	@Column
	private String productId;

	@Nonnull
	@Column
	private String brandId;

	@Nonnull
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private LocalDateTime startDate;

	@Nonnull
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private LocalDateTime endDate;

	@Nonnull
	@Column
	private BigDecimal price;

	@Nonnull
	@Column
	private String currency;

	@Nonnull
	@Column
	private int priority;

	public TariffEntity(String priceList, String productId, String brandId, LocalDateTime startDate, LocalDateTime endDate,
			BigDecimal price, String currency, int priority) {
		super();
		this.priceList = priceList;
		this.productId = productId;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.currency = currency;
		this.priority = priority;
	}
	
	public TariffEntity() { }

	public String getPriceList() {
		return priceList;
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

	static public Tariff toModel(TariffEntity tariffEntity) {
		return new Tariff(
				tariffEntity.getPriceList(), 
				tariffEntity.getProductId(), 
				tariffEntity.getBrandId(),
				tariffEntity.getStartDate(), 
				tariffEntity.getEndDate(), 
				tariffEntity.getPrice(),
				tariffEntity.getCurrency(), 
				tariffEntity.getPriority());
	}

}
