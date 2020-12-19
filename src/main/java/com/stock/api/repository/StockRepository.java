package com.stock.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.api.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

}
