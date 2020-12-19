package com.stock.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stock.api.model.Stock;
import com.stock.api.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;

	@Override
	public Stock createStock(Stock stock) {
		return stockRepository.save(stock);
	}

	@Override
	public List<Stock> readAllStocks() {
		return stockRepository.findAll();
	}

	@Override
	public Stock readStockByName(String name) {
		Optional<Stock> stock = stockRepository.findById(name);
		if(!stock.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Name not found");
		}
		
		return stock.get();
	}

	@Override
	public void deleteStock(String name) {
		Optional<Stock> stock = stockRepository.findById(name);
		if(!stock.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Name not found");
		}
		stockRepository.deleteById(name);
	}



}
