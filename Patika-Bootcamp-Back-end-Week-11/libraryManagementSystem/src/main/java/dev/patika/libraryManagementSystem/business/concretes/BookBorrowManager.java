package dev.patika.libraryManagementSystem.business.concretes;

import dev.patika.libraryManagementSystem.business.abstracts.IBookBorrowService;
import dev.patika.libraryManagementSystem.core.exception.NotFoundException;
import dev.patika.libraryManagementSystem.core.utilies.Msg;
import dev.patika.libraryManagementSystem.dao.BookBorrowRepo;
import dev.patika.libraryManagementSystem.entity.BookBorrowing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowManager implements IBookBorrowService {
    private final BookBorrowRepo bookBorrowRepo;

    public BookBorrowManager(BookBorrowRepo bookBorrowRepo) {
        this.bookBorrowRepo = bookBorrowRepo;
    }

    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return this.bookBorrowRepo.save(bookBorrowing);
    }

    @Override
    public BookBorrowing get(int id) {
        return this.bookBorrowRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.bookBorrowRepo.findAll(pageable);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        this.get(bookBorrowing.getId());
        return this.bookBorrowRepo.save(bookBorrowing);
    }

    @Override
    public List<BookBorrowing> getAll() {
        return bookBorrowRepo.findAll();
    }

    @Override
    public boolean delete(int id) {
        BookBorrowing bookBorrowing = this.get(id);
        this.bookBorrowRepo.delete(bookBorrowing);
        return true;
    }
}
