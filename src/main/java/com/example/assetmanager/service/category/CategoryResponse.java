package com.example.assetmanager.service.category;

import com.example.assetmanager.domain.Category;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CategoryResponse {

    private Long id;
    private String name;
    private List<String> categoryNames;

    public static CategoryResponse of(@NonNull Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());


        List<Category> categories = new ArrayList<>();
        List<String> names = categories.stream().map(Category::getName).toList();
        response.setCategoryNames(names);
        return response;
    }

    public static List<CategoryResponse> of(@NonNull List<Category> categories) {
        return categories.stream().map(CategoryResponse::of).collect(Collectors.toList());
    }
}
