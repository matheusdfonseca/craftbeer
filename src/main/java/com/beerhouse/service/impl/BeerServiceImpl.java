package com.beerhouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;
import com.beerhouse.service.BeerService;

@Service
public class BeerServiceImpl implements BeerService {
	@Autowired
	private BeerRepository repository;

	@Override
	public List<Beer> find() {
		List<Beer> beer = repository.findAll();
		return beer;
	}

	@Override
	public Optional<Beer> get(Long id) {		
		return repository.findById(id);
	}

	@Override
	public Beer create(Beer beer) {
		
		return repository.save(beer);
	}

	@Override
	public void remove(Long id) {
		repository.removeBeerIngredientById(id);
		repository.deleteById(id);

	}

}
