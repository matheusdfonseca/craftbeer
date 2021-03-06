package com.beerhouse.service;

import com.beerhouse.model.Ingredient;

public interface IngredientService {

	    Ingredient get(Long id);
	    
	    Ingredient getByName(String name);
	    
	    Ingredient create(Ingredient ingredient);
	    
	    Ingredient isIngredientExists(String nomeIngredient);

		
	}


