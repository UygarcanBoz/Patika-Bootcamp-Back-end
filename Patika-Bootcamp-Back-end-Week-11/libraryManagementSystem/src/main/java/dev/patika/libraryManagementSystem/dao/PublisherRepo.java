package dev.patika.libraryManagementSystem.dao;

import dev.patika.libraryManagementSystem.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
