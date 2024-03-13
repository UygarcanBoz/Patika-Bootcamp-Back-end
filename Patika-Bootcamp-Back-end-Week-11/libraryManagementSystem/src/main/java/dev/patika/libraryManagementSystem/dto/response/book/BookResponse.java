package dev.patika.libraryManagementSystem.dto.response.book;

import dev.patika.libraryManagementSystem.entity.BookBorrowing;
import dev.patika.libraryManagementSystem.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private int id;
    private String name;
    private int publicationYear;
    private int stock;
    private int publisherId;
    private int authorId;
    private List<Category> categoryList;
}
