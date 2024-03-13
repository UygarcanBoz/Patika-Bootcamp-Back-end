package dev.patika.libraryManagementSystem.dto.request.book;

import dev.patika.libraryManagementSystem.entity.BookBorrowing;
import dev.patika.libraryManagementSystem.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
    @NotNull(message = "Kitap adı boş olamaz")
    private String name;

    @NotNull(message = "Kitap Yayın Tarihi boş olamaz")
    private int publicationYear;

    @NotNull(message = "Kitap Stok bilgisi boş olamaz")
    private int stock;
    private int publisherId;
    private int authorId;
    private List<Category> categoryList;
}
