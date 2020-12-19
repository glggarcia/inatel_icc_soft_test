package com.stock.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stock.api.model.Stock;
import com.stock.api.service.StockServiceImpl;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockServiceImpl stockService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Stock create(@RequestBody @Validated Stock stock) {
		return stockService.createStock(stock);
	}
	
	@GetMapping
	public List<Stock> getAll() {
		return stockService.readAllStocks();
	}
	
	@PutMapping("/{stock_name}")
	public Stock updateStock(@PathVariable("stock_name") String stockName, @RequestBody List<Float> quotes) {
		return stockService.updateStock(stockName, quotes);
	}
	
	@DeleteMapping("/{stock_name}")
	public void deleteStock(@PathVariable("stock_name") String stockName) {
		stockService.deleteStock(stockName);
	}
	
}
