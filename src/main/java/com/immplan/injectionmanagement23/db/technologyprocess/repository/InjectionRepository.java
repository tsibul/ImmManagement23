package com.immplan.injectionmanagement23.db.technologyprocess.repository;

import com.immplan.injectionmanagement23.db.technologyprocess.Injection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InjectionRepository extends JpaRepository<Injection, Long> {
}
