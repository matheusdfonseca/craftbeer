package com.beerhouse.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.beerhouse.model.Beer;

public class BeerDto {
	
	@NotBlank @NotNull
	private Long id;
	@NotBlank @NotNull
	private String name;
	@NotBlank @NotNull
	private String ingredients;
	@NotBlank @NotNull
	private String alcoholContent;
	@NotBlank @NotNull
	private BigDecimal price;
	@NotBlank @NotNull
	private String categoryName;

	public BeerDto(Beer beer) {
		this.id = beer.getId();
		this.name = beer.getName();
		this.ingredients = beer.getIngredients().toString();
		this.alcoholContent = beer.getAlcoholContent().toString().concat("%");
		this.price = beer.getPrice();
		this.categoryName = beer.getCategory().getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIngredientName() {
		return ingredients;
	}

	public String getAlcoholContent() {
		return alcoholContent;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public static List<BeerDto> toBeerDto(List<Beer> beers) {
	
		return beers.stream().map(BeerDto::new).collect(Collectors.toList());
	}

}
