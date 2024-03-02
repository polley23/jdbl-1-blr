package com.gfg.librarymanagement.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bName;
    private String author;
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private Inventory inventory;
    @OneToMany
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
