package com.stock.api.service;

import java.util.List;

import com.stock.api.model.Stock;

public interface StockService {
	
	Stock createStock(Stock stock);
	
	List<Stock> readAllStocks();
	
	Stock readStockByName(String name);
	
	void deleteStock(String name);
}
