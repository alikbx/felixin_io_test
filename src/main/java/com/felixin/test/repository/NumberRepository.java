package com.felixin.test.repository;

import com.felixin.test.domain.FelixinNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<FelixinNumber, Long> {
}
