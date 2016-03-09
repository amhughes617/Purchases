package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by alexanderhughes on 3/9/16.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
