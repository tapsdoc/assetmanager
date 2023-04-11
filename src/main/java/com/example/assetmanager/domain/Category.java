package com.example.assetmanager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    private Long id;
    private String name;
    @OneToMany(
        mappedBy = "category",
        orphanRemoval = true,
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
        fetch = FetchType.LAZY
    )
    private List<Asset> assets = new ArrayList<>();

    public void addAsset(Asset asset) {
        if (!assets.contains(asset)) {
            assets.add(asset);
            asset.setCategory(this);
        }
    }

    public void removeAsset(Asset asset) {
        if (assets.contains(asset)) {
            assets.remove(asset);
            asset.setCategory(null);
        }
    }

}
