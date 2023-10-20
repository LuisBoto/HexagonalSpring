package com.luisboto.outbound.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luisboto.outbound.entity.TariffEntity;

@Repository
public interface TariffRepository extends JpaRepository<TariffEntity, Long> {
	
	@Query("""
				select 1 t
			     from TariffEntity t
			     where t.productId = ?1 AND t.brandId = ?2 AND t.startDate <= ?3 AND t.endDate >= ?3 
			     order by t.priority DESC
			""")
	TariffEntity findActiveTariffByProductBrandAndDate(String productId, String brandId, Date applicationDate);

}
