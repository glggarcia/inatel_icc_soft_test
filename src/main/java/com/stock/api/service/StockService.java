package com.stock.api.service;

import java.util.List;

import com.stock.api.model.Stock;

public interface StockService {

	Stock createStock(Stock stock);

	List<Stock> readAllStocks();
	
	Stock updateStock(String name, Stock stockPartialUpdate);

	void deleteStock(String name);
}
