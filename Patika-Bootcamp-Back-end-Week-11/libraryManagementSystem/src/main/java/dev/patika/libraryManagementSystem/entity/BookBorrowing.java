package dev.patika.libraryManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "book_borrows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private int id;

    @NotNull
    @Column(name = "borrower_name")
    private String borrowerName;

    @NotNull
    @Column(name = "borrowing_date")
    private LocalDate borrowingDate;

    @NotNull
    @Column(name = "borrow_return_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "borrow_book_id", referencedColumnName = "book_id")
    private Book book;
}
