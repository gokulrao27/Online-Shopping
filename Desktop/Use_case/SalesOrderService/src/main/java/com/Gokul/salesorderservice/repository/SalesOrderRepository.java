package com.Gokul.salesorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gokul.salesorderservice.datamodel.SalesOrder;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
}
