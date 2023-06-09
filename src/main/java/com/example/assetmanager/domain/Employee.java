package com.example.assetmanager.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(name = "unique_phone_number", columnNames = {"phone_number"})
    }
)
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
        name = "users_id",
        referencedColumnName = "id"
    )
    private Users users;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @OneToOne
    @JoinColumn
    private Department department;
    @Column(nullable = false)
    private String designation;
    @Column(name = "phone_number", nullable = false, unique = true, length = 10)
    private String phoneNumber;
    private String address;
    private String profileImage;

    @Builder
    public Employee(
        Users users,
        String firstName,
        String lastName,
        Department department,
        String designation,
        String phoneNumber,
        String address,
        String profileImage) {

        this.users = users;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profileImage = profileImage;
    }
}
