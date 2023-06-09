package com.example.assetmanager.domain;

import com.example.assetmanager.common.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(name = "unique_employee_email", columnNames = {"email"})
    }
)
@NoArgsConstructor
@Data
public class Users implements UserDetails {

    @Id
    @SequenceGenerator(
        name = "user_seq",
        sequenceName = "users_seq",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(nullable = false)
    private String password;
    private boolean locked;
    private boolean enabled;
    @OneToOne(
            mappedBy = "users",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private Employee employee;

    @Builder
    public Users(Role role, String email, String password, boolean locked, boolean enabled) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.locked = locked;
        this.enabled = enabled;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
