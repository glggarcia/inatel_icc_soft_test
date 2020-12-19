package com.stock.api.service;

import java.util.List;

import com.stock.api.model.Stock;

public interface StockService {

	Stock createStock(Stock stock);

	List<Stock> readAllStocks();

	Stock readStockByName(String name);
	
	Stock updateStock(String name, List<Float> quotes);

	void deleteStock(String name);
}
