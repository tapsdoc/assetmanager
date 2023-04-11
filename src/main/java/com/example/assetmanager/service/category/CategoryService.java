package com.example.assetmanager.service.category;

import java.util.List;

public interface CategoryService {

    CategoryResponse addCategory(CategoryRequest request);
    CategoryResponse getCategoryById(Long id);
    CategoryResponse editCategory(Long id, CategoryRequest request);
    List<CategoryResponse> getAll();
    void delete(Long id);
}
