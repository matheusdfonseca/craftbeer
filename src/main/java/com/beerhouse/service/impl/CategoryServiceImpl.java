package com.beerhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.model.Category;
import com.beerhouse.repository.CategoryRepository;
import com.beerhouse.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository repository;

	@Override
	public List<Category> find() {
		return null;
	}

	@Override
	public Category getByNameCategory(String name) {
		return repository.findByNome(name);
	}

	@Override
	public Category create(Category category) {		
		return repository.save(category);
	}


	@Override
	public Category isCategoryExists(String nameCategory) {
		Category category = getByNameCategory(nameCategory);
		if (category != null) {
			return category;
		} else {
			return create(new Category(nameCategory));
		}

	}

}
