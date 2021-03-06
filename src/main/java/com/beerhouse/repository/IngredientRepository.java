package com.beerhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beerhouse.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	
	@Query("SELECT i FROM Ingredient i WHERE i.name = ?1")
	Ingredient findByName(String nome);

	
}