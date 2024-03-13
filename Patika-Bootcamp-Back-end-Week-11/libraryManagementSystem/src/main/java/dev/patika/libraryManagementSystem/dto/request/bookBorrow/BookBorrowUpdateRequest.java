package dev.patika.libraryManagementSystem.dto.request.bookBorrow;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowUpdateRequest {

    @Positive(message = "ID değeri pozitif olmak zorundadır.")
    private int id;

    @NotNull(message = "Kiralayan kişi adı boş olamaz")
    private String borrowerName;

    @NotNull(message = "Kiralam tarihi boş olamaz")
    private LocalDate borrowingDate;

    @NotNull(message = "Teslim tarihi boş olamaz")
    private LocalDate returnDate;
}
