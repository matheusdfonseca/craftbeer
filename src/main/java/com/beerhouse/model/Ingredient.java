package com.beerhouse.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "ingredients")
	private List<Beer> beers;
	
	public Ingredient() {
		
	}

	public Ingredient(String nameIngredient) {
		this.name = nameIngredient;
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

	@Override
	public String toString() {
		return name;
	}

}
