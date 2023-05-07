package com.immplan.injectionmanagement23.db.producer.repository;

import com.immplan.injectionmanagement23.db.producer.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
