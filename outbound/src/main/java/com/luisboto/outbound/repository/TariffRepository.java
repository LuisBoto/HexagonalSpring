package com.luisboto.outbound.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luisboto.outbound.entity.TariffEntity;

@Repository
public interface TariffRepository extends JpaRepository<TariffEntity, Long> {
	
	@Query(value = """
				select *
			     from prices p
			     where p.product_id = ?1 AND p.brand_id = ?2 AND p.start_date <= ?3 AND p.end_date >= ?3 
			     order by p.priority DESC
			     LIMIT 1
			""", nativeQuery = true)
	TariffEntity findActiveTariffByProductBrandAndDate(String productId, String brandId, LocalDateTime applicationDate);

}
