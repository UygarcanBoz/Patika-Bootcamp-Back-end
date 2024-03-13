package dev.patika.libraryManagementSystem.dao;

import dev.patika.libraryManagementSystem.entity.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowRepo extends JpaRepository<BookBorrowing, Integer> {
}
