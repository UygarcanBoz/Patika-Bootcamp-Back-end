package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Author author = new Author();
        author.setName("Victor HUGO");
        author.setBirthDate(LocalDate.of(1903,01,01));
        author.setCountry("France");
        entityManager.persist(author);

        Publisher publisher = new Publisher();
        publisher.setName("Can Kitabevi");
        publisher.setAddress("İstanbul");
        publisher.setEstablishmentYear(2000);
        entityManager.persist(publisher);

        Category categoryNovel = new Category();
        categoryNovel.setDescription("Novel");
        categoryNovel.setName("a fictitious prose narrative of book length, typically representing character and action with some degree of realism.");
        entityManager.persist(categoryNovel);

        Category categoryAction = new Category();
        categoryAction.setDescription("Action");
        categoryAction.setName("Action fiction is a literary genre that focuses on stories that involve high-stakes, high-energy, and fast-paced events.");
        entityManager.persist(categoryAction);

        Book book = new Book();
        book.setName("Les Misérables");
        book.setStock(10);
        book.setPublicationYear(1862);
        book.setAuthor(author);
        book.setPublisher(publisher);

        List<Category> categories = new ArrayList<>();
        categories.add(categoryNovel);
        categories.add(categoryAction);
        book.setCategoryList(categories);
        entityManager.persist(book);

        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Uygarcan Boz");
        bookBorrowing.setBook(book);
        bookBorrowing.setBorrowingDate(LocalDate.now());
        bookBorrowing.setReturnDate(null);
        entityManager.persist(bookBorrowing);

        System.out.println(book);

        transaction.commit();
    }
}