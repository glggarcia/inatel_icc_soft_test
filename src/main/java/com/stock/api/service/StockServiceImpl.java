package com.stock.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		stock.setName(stock.getName().toUpperCase());
		return stockRepository.save(stock);
	}

	@Override
	public ResponseEntity<?> readAllStocks() {
		return ResponseEntity.ok().body(stockRepository.findAll());
	}

	@Override
	public ResponseEntity<?> readOneStock(String name) {
		return ResponseEntity.ok().body(stockRepository.findById(name));
	}

	@Override
	public void deleteStock(String name) {

		this.stock = this.getStockById(name.toUpperCase()).get();
		stockRepository.deleteById(this.stock.getName());
	}

	@Override
	public Stock updateStock(String name, Stock stockPartialUpdate) {
		this.stock = this.getStockById(name).get();
		List<Float> stockQuotes = this.stock.getQuotes();
		stockQuotes.addAll(stockPartialUpdate.getQuotes());
		this.stock.setName(this.stock.getName().toUpperCase());
		this.stock.setQuotes(stockQuotes);
		return stockRepository.save(this.stock);
	}

	private Optional<Stock> getStockById(String name) {
		name = name.toUpperCase();
		Optional<Stock> returnedStock = stockRepository.findById(name);
		if (!returnedStock.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock name not exists");
		}

		return returnedStock;
	}
}
