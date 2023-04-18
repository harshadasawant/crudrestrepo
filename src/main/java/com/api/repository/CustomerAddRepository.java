package com.api.repository;

import com.api.entity.CustomerAdd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddRepository extends CrudRepository<CustomerAdd, Integer> {
}
