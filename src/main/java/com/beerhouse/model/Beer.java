package com.beerhouse.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Beer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double alcoholContent;
	private BigDecimal price;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "BEER_INGREDIENTS", joinColumns = { @JoinColumn(name = "BEERS_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "INGREDIENTS_ID") })
	private List<Ingredient> ingredients;
	@ManyToOne
	private Category category;

	public Beer() {

	}

	public Beer(String name, Double alcoholContent, BigDecimal price, Category category, List<Ingredient> ingredients) {
		this.name = name;
		this.alcoholContent = alcoholContent;
		this.price = price;
		this.ingredients = ingredients;
		this.category = category;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAlcoholContent(Double alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public Category getCategory() {
		return category;
	}

	public Double getAlcoholContent() {
		return alcoholContent;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public Beer populate(Beer updateBeer) {
		return null;
	}

}
