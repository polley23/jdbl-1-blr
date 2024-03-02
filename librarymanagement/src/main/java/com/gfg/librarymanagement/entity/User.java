package com.gfg.librarymanagement.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private FineAmount fineAmount;
    @ManyToOne
    private Book book;
}
