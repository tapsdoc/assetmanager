package com.example.assetmanager.domain;

import com.example.assetmanager.common.Action;
import com.example.assetmanager.common.AssetStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(name = "assetId_unique", columnNames = {"asset_id"}),
        @UniqueConstraint(name = "assetModelNumber_unique", columnNames = {"asset_model_number"}),
        @UniqueConstraint(name = "serial_unique", columnNames = {"serial_number"})
    }
)
@NoArgsConstructor
@Data
public class Asset {

    @Id
    @SequenceGenerator(name = "asset_is_seq", sequenceName = "asset_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asset_id_seq")
    private Long id;
    @Column(name = "asset_id", unique = true, nullable = false)
    private String assetId;
    @Column(name = "asset_model_number", unique = true, nullable = false)
    private String assetModelNumber;
    @Column(name = "serial_number", unique = true, nullable = false)
    private String serialNumber;
    private String name;
    private String description;
    private Double unitPrice;
    private String image;
    private String dateOfPurchase;
    private String dateOfAssignment;
    private String dateOfManufacture;
    @Enumerated(EnumType.STRING)
    private AssetStatus assetStatus;
    @Enumerated(EnumType.STRING)
    private Action action;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private Category category;

    @Builder
    public Asset(String assetId, String assetModelNumber, String serialNumber, String name, String description, Double unitPrice, String image, String dateOfPurchase, String dateOfAssignment, String dateOfManufacture, AssetStatus assetStatus, Action action, Supplier supplier, Category category) {
        this.assetId = assetId;
        this.assetModelNumber = assetModelNumber;
        this.serialNumber = serialNumber;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.image = image;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfAssignment = dateOfAssignment;
        this.dateOfManufacture = dateOfManufacture;
        this.assetStatus = assetStatus;
        this.action = action;
        this.supplier = supplier;
        this.category = category;
    }
}
