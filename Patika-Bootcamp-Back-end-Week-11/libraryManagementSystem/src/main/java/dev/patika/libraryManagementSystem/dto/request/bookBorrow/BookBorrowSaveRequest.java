package dev.patika.libraryManagementSystem.dto.request.bookBorrow;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowSaveRequest {
    @NotNull(message = "Kiralayan kişi adı boş olamaz")
    private String borrowerName;

    @NotNull(message = "Kiralam tarihi boş olamaz")
    private LocalDate borrowingDate;

    @NotNull(message = "Teslim tarihi boş olamaz")
    private LocalDate returnDate;
    private int bookId;
}
