package com.beerhouse.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "category")
	private List<Beer> beers;
	
	public Category() {
		
	}
	
	public Category(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.beers = category.getBeers();
	}

	public Category(String nameCategory) {
		this.name = nameCategory;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Beer> getBeers() {
		return beers;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
