package com.example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by alexanderhughes on 3/9/16.
 */
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Integer> {
    Page<Purchase> findByCategoryIgnoreCase (Pageable pageable, String category);
    Page<Purchase> findAll(Pageable pageable);
}

