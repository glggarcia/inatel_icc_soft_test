package com.stock.api.service;

import org.springframework.http.ResponseEntity;

import com.stock.api.model.Stock;

public interface StockService {

	Stock createStock(Stock stock);

	ResponseEntity<?> readAllStocks();
	
	ResponseEntity<?> readOneStock(String name);
		
	Stock updateStock(String name, Stock stockPartialUpdate);

	void deleteStock(String name);
}
