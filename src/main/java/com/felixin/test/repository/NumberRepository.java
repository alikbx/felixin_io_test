package com.felixin.test.repository;

import com.felixin.test.domain.FelixinNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NumberRepository extends JpaRepository<FelixinNumber, Long> {

    List<FelixinNumber> findTop10ByNumberGreaterThanOrderByNumberAsc(int number);

    List<FelixinNumber> findTop10ByNumberLessThanOrderByNumberDesc(int number);
}
