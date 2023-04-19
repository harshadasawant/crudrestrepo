package com.api.repository;

import com.api.entity.Card;
import org.springframework.data.repository.CrudRepository;
public interface CardRepository extends CrudRepository<Card, Integer> {
}
