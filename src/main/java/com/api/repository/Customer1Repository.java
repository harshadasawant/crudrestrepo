package com.api.repository;

import com.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer1Repository extends JpaRepository<Customer, Integer> {
}
