package dev.patika.libraryManagementSystem.business.abstracts;

import dev.patika.libraryManagementSystem.entity.BookBorrowing;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBookBorrowService {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing get(int id);
    Page<BookBorrowing> cursor(int page, int pageSize);
    BookBorrowing update(BookBorrowing bookBorrowing);
    List<BookBorrowing> getAll();
    boolean delete(int id);

}
