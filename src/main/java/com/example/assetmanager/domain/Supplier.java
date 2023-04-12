package com.example.assetmanager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    private Long id;
    private String name;
    private String address;
    private String contactNumber;
    private String contactEmail;

    @Builder
    public Supplier(String name, String address, String contactNumber, String contactEmail) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
    }
}
