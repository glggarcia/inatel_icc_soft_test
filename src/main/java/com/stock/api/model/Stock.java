package com.stock.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {

	@Id
	private String name;
	
	List<Float> quotes;
	
}

