package com.beerhouse.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.beerhouse.controller.dto.BeerDto;
import com.beerhouse.controller.form.BeerForm;
import com.beerhouse.model.Beer;
import com.beerhouse.model.Category;
import com.beerhouse.model.Ingredient;
import com.beerhouse.service.BeerService;
import com.beerhouse.service.CategoryService;
import com.beerhouse.service.IngredientService;

@RestController
@RequestMapping("/beer")
public class BeerController {
	@Autowired
	private BeerService service;
	@Autowired
	private IngredientService serviceIngredient;
	@Autowired
	private CategoryService serviceCategory;

	@GetMapping
	public List<BeerDto> get() {
		return BeerDto.toBeerDto(new ArrayList<Beer>(service.find()));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<BeerDto> post(@RequestBody @Valid BeerForm form, UriComponentsBuilder uriBuilder) {
		
		List<Ingredient> ingredients = form.toList(form.getIngredients(), serviceIngredient);
		Category category = serviceCategory.isCategoryExists(form.getCategoryName());
		
		Beer beer = form.toBeer(ingredients, category);
		service.create(beer);

		URI uri = uriBuilder.path("/beer/{id}").buildAndExpand(beer.getId()).toUri();
		return ResponseEntity.created(uri).body(new BeerDto(beer));
	}

	@GetMapping("/{id}")
	public ResponseEntity<BeerDto> getbyId(@Valid @PathVariable Long id) {
		Optional<Beer> beer = service.get(id);
		if (beer.isPresent()) {
			return ResponseEntity.ok(new BeerDto(beer.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<BeerDto> put(@PathVariable Long id, @RequestBody @Valid BeerForm form) {
		List<Ingredient> ingredients = form.toList(form.getIngredients(), serviceIngredient);
		Category category = serviceCategory.isCategoryExists(form.getCategoryName());
		Optional<Beer> optional = service.get(id);
		if (optional.isPresent()) {
			Beer beer = form.atualizar(id, optional.get(), ingredients, category);
			return ResponseEntity.ok(new BeerDto(beer));
		}

		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/{id}")
	@Transactional
	public ResponseEntity<BeerDto> patch(@PathVariable Long id, @RequestBody @Valid BeerForm form) {
		List<Ingredient> ingredients = form.toList(form.getIngredients(), serviceIngredient);
		Category category = serviceCategory.isCategoryExists(form.getCategoryName());
		Optional<Beer> optional = service.get(id);
		if (optional.isPresent()) {
			Beer beer = form.atualizar(id, optional.get(), ingredients, category);
			return ResponseEntity.ok(new BeerDto(beer));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
		Optional<Beer> beer = service.get(id);
		if (beer.isPresent()) {
			service.remove(id);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

}
