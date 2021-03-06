package com.beerhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.beerhouse.model.Beer;

public interface BeerRepository extends JpaRepository<Beer, Long> {
	
	@Modifying
	@Query(value = "DELETE FROM BEER_INGREDIENTS WHERE BEERS_ID = ?1", nativeQuery = true)
	void removeBeerIngredientById(Long id);
}
