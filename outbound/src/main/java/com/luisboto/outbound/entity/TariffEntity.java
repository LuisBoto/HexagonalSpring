package com.luisboto.outbound.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.luisboto.core.model.Tariff;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tariff")
public class TariffEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Nonnull
	private String productId;
	
	@Nonnull
	private String brandId;
	
	@Nonnull
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Nonnull
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Nonnull
	private BigDecimal price;
	
	@Nonnull
	private String currency;
	
	@Nonnull
	private int priority;

	public TariffEntity(String id, String productId, String brandId, Date startDate, Date endDate, BigDecimal price,
			String currency, int priority) {
		super();
		this.id = id;
		this.productId = productId;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.currency = currency;
		this.priority = priority;
	}
	
	static public Tariff toModel(TariffEntity tariffEntity) {
		return new Tariff(
				tariffEntity.productId,
				tariffEntity.brandId,
				tariffEntity.startDate,
				tariffEntity.endDate,
				tariffEntity.price,
				tariffEntity.currency,
				tariffEntity.priority
			);
	}
	
}
