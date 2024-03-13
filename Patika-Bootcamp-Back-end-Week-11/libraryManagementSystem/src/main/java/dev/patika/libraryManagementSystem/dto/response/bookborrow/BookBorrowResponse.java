package dev.patika.libraryManagementSystem.dto.response.bookborrow;

import dev.patika.libraryManagementSystem.entity.Book;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowResponse {
    private int id;
    private String borrowerName;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
}
