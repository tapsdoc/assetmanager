package com.example.assetmanager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Name is mandatory")
    @Column(unique = true)
    private String name;
    private String address;
    @NotBlank(message = "Contact number is mandatory")
    private String contactNumber;
    @NotBlank(message = "Email is mandatory")
    @Email
    private String contactEmail;

    @Builder
    public Supplier(String name, String address, String contactNumber, String contactEmail) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
    }
}
