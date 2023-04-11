package com.example.assetmanager.domain;

import com.example.assetmanager.common.Action;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetHistory {

    @SequenceGenerator(name = "asset_history_seq", sequenceName = "asset_history_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asset_history_seq")
    @Id
    private Long id;
    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JoinColumn
    private Asset asset;
    @ManyToOne(
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
        fetch = FetchType.LAZY
    )
    @JoinColumn
    private Employee employee;
    @Enumerated(value = EnumType.STRING)
    private Action action;
    private String note;
    private String dateOfCreation;
}
