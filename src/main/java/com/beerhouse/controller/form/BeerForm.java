package com.beerhouse.controller.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.beerhouse.controller.dto.BeerDto;
import com.beerhouse.model.Beer;
import com.beerhouse.model.Category;
import com.beerhouse.model.Ingredient;
import com.beerhouse.service.IngredientService;

public class BeerForm {
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

	public BeerForm() {
	}

	public BeerForm(String name, String ingredients, String alcoholContent, BigDecimal price, String categoryName) {
		this.name = name;
		this.ingredients = ingredients;
		this.alcoholContent = alcoholContent;
		this.price = price;
		this.categoryName = categoryName;
	}

	public String getName() {
		return name;
	}

	public String getIngredients() {
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

	public List<Ingredient> toList(String ingrediets, IngredientService ingredientService) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Arrays.asList(this.ingredients.split(",")).stream().forEach(i -> {
			ingredients.add(ingredientService.isIngredientExists(i.trim()));
		});
		return ingredients;
	}

	public Double toDouble(String alcoholContent) {
		return Double.valueOf(alcoholContent.replace("%", "").trim());
	}

	public static List<BeerDto> toBeerDto(List<Beer> beers) {
		return beers.stream().map(BeerDto::new).collect(Collectors.toList());
	}

	public Beer toBeer(List<Ingredient> ingredients, Category category) {
		return new Beer(name, toDouble(alcoholContent), price, category, ingredients);
	}

	public Beer atualizar(Long id, Beer beer, List<Ingredient> ingredients, Category category) {
		beer.setName(this.name);
		beer.setAlcoholContent(toDouble(this.alcoholContent));
		beer.setPrice(this.price);
		beer.setIngredients(ingredients);
		beer.setCategory(category);

		return beer;
	}
}
