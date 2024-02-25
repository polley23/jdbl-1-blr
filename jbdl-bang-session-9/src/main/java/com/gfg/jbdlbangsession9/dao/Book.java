package com.gfg.jbdlbangsession9.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bname;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Author> author;
    private String publisherName;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Genre genre;
    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<BookVolume> bookVolumes;
}
