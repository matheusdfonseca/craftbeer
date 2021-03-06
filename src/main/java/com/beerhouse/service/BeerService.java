package com.beerhouse.service;

import java.util.List;
import java.util.Optional;

import com.beerhouse.model.Beer;

public interface BeerService {

	    List<Beer> find();

	    Optional<Beer> get(Long id);

	    Beer create(Beer beer);

	    void remove(Long id);

	}


