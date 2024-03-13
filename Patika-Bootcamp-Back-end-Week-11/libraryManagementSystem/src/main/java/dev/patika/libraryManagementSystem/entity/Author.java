package dev.patika.libraryManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition = "serial")
    private int id;

    @NotNull
    @Column(name = "author_name")
    private String name;

    @NotNull
    @Column(name = "author_birthday")
    private LocalDate birthday;

    @NotNull
    @Column(name = "author_country")
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> booksList;
}
