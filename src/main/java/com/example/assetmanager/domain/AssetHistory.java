package com.example.assetmanager.domain;

import com.example.assetmanager.common.Action;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private boolean isAssigned;
    private boolean isDamaged;
    private boolean isReturned;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime actionDate;

    @Builder
    public AssetHistory(Asset asset, Employee employee, Action action, String note, boolean isAssigned, boolean isDamaged, boolean isReturned, LocalDateTime actionDate) {
        this.asset = asset;
        this.employee = employee;
        this.action = action;
        this.note = note;
        this.isAssigned = isAssigned;
        this.isDamaged = isDamaged;
        this.isReturned = isReturned;
        this.actionDate = actionDate;
    }
}
