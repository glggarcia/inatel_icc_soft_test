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
	
	private Stock stock;
	
	@Autowired
	private StockRepository stockRepository;

	@Override
	public Stock createStock(Stock stock) {
		return stockRepository.saveAndFlush(stock);
	}

	@Override
	public List<Stock> readAllStocks() {
		return stockRepository.findAll();
	}

	@Override
	public Stock readStockByName(String name) {
		return this.getStockById(name).get();
		
	}

	@Override
	public void deleteStock(String name) {
		this.stock = this.getStockById(name).get();
		stockRepository.deleteById(this.stock.getName());
	}

	@Override
	public Stock updateStock(String name, List<Float> quotes) {
		this.stock = this.getStockById(name).get();
		List<Float> stockList = this.stock.getQuotes();
	
		quotes.forEach(quotesValue -> stockList.add(quotesValue));
		this.stock.setQuotes(stockList);
		return stockRepository.save(this.stock);
	}
	
	
	private Optional<Stock> getStockById(String name)
	{
		Optional<Stock> returnedStock = stockRepository.findById(name);
		if(!returnedStock.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock name not exists");
		}
		
		return returnedStock;
	}



}
