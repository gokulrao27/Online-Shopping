package com.Gokul.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gokul.customers.datamodel.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

}
