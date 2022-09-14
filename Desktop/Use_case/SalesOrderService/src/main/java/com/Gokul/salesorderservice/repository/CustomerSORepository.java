package com.Gokul.salesorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gokul.salesorderservice.datamodel.Customer;

@Repository
public interface CustomerSORepository extends JpaRepository<Customer, Long> {
}
