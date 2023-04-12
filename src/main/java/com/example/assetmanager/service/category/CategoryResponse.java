package com.example.assetmanager.service.category;

import com.example.assetmanager.domain.Asset;
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
    private List<String> assetNames;

    public static CategoryResponse of(@NonNull Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        List<Asset> assets = new ArrayList<>();
        List<String> names = assets.stream().map(Asset::getName).toList();
        response.setAssetNames(names);
        return response;
    }

    public static List<CategoryResponse> of(@NonNull List<Category> categories) {
        return categories.stream().map(CategoryResponse::of).collect(Collectors.toList());
    }
}
