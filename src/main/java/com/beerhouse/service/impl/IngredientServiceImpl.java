package com.beerhouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.model.Ingredient;
import com.beerhouse.repository.IngredientRepository;
import com.beerhouse.service.IngredientService;

@Service
public class IngredientServiceImpl  implements IngredientService  {
	@Autowired
	private IngredientRepository repository;

	@Override
	public Ingredient get(Long id) {
		return repository.getOne(id);
	}

	@Override
	public Ingredient getByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Ingredient create(Ingredient ingredient) {
		return repository.save(ingredient);
	}

	
	@Override
	public Ingredient isIngredientExists(String nameIngredient) {
		Ingredient ingredient = getByName(nameIngredient);
		if (ingredient != null) {
			return ingredient;
		} else {
			return create(new Ingredient(nameIngredient));
		}

	}






}
