package com.luisboto.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisboto.outbound.entity.TariffEntity;

@Repository
public interface TariffRepository extends JpaRepository<TariffEntity, Long> {

}
