package com.example.assetmanager.domain;

import com.example.assetmanager.common.AssetStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(name = "assetId_unique", columnNames = {"assetId"}),
        @UniqueConstraint(name = "assetModelNumber_unique", columnNames = {"assetModelNumber"}),
        @UniqueConstraint(name = "serial_unique", columnNames = {"serialNumber"})
    }
)
@NoArgsConstructor
@Data
public class Asset {

    @Id
    @SequenceGenerator(name = "asset_is_seq", sequenceName = "asset_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asset_id_seq")
    private Long id;
    @Column(unique = true, nullable = false)
    private String assetId;
    @Column(unique = true, nullable = false)
    private String assetModelNumber;
    @Column(unique = true, nullable = false)
    private String serialNumber;
    private String name;
    private String description;
    private Double unitPrice;
    private String image;
    private LocalDate dateOfPurchase;
    private LocalDate dateOfAssignment;
    private LocalDate dateOfManufacture;
    @Enumerated(EnumType.STRING)
    private AssetStatus assetStatus;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private Category category;

    @Builder

    public Asset(String assetId, String assetModelNumber, String serialNumber, String name, String description, Double unitPrice, String image, LocalDate dateOfPurchase, LocalDate dateOfAssignment, LocalDate dateOfManufacture, AssetStatus assetStatus, Supplier supplier, Category category) {
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
        this.supplier = supplier;
        this.category = category;
    }
}
