package com.example.assetmanager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Employee employee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Asset asset;
    @Column(nullable = false)
    private String message;
    private LocalDateTime dateOfComment;
}
