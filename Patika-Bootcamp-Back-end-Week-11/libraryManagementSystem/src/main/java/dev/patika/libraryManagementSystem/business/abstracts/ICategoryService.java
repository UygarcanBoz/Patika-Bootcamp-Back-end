package dev.patika.libraryManagementSystem.business.abstracts;

import dev.patika.libraryManagementSystem.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    Category save(Category category);
    Category get(int id);
    Page<Category> cursor(int page, int pageSize);
    Category update(Category category);
    boolean delete(int id);
    List<Category> getAllByIds(List<Integer> categoryIds);
}
