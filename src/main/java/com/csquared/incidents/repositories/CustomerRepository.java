package com.csquared.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquared.incidents.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
}
