package com.beerhouse.service;

import java.util.List;

import com.beerhouse.model.Category;

public interface CategoryService {

	    List<Category> find();
    
	    Category getByNameCategory(String name);

	    Category create(Category category);

		Category isCategoryExists(String nomeCategory);


	}


