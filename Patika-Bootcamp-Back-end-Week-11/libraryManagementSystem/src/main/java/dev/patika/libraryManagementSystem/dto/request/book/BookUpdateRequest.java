package dev.patika.libraryManagementSystem.dto.request.book;

import dev.patika.libraryManagementSystem.entity.BookBorrowing;
import dev.patika.libraryManagementSystem.entity.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {
    @Positive(message = "ID Değeri pozitif olmak zorunda")
    private int id;

    @NotNull(message = "Kitap adı boş olamaz")
    private String name;

    @NotNull(message = "Kitap Yayın Tarihi boş olamaz")
    private int publicationYear;

    @NotNull(message = "Kitap Stok bilgisi boş olamaz")
    private int stock;
    private int publisherId;
    private int authorId;
    private List<BookBorrowing> bookBorrowingList;
    private List<Category> categoryList;
}
