package com.example.assetmanager.service.category;

import com.example.assetmanager.domain.Category;
import com.example.assetmanager.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public CategoryResponse addCategory(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        var savedCategory = categoryRepo.save(category);
        return CategoryResponse.of(savedCategory);
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if (category.isEmpty()){
            throw new IllegalStateException("Category not found");
        }
        return CategoryResponse.of(category.get());
    }

    @Override
    public CategoryResponse editCategory(Long id, CategoryRequest request) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalStateException("Category not found"));
        if (request.getName() != null) {
            category.setName(request.getName());
        }
        var update = categoryRepo.save(category);
        return CategoryResponse.of(update);
    }

    @Override
    public List<CategoryResponse> getAll() {
        List<Category> categories = new ArrayList<>(categoryRepo.findAll());
        return CategoryResponse.of(categories);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalStateException("Category not found");
        }
        categoryRepo.deleteById(id);
    }
}
