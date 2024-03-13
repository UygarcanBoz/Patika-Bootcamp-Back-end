package dev.patika.libraryManagementSystem.api;

import dev.patika.libraryManagementSystem.business.abstracts.*;
import dev.patika.libraryManagementSystem.core.config.modelMapper.IModelMapperService;
import dev.patika.libraryManagementSystem.core.result.ResultData;
import dev.patika.libraryManagementSystem.core.utilies.ResultHelper;
import dev.patika.libraryManagementSystem.dto.request.book.BookSaveRequest;
import dev.patika.libraryManagementSystem.dto.response.book.BookResponse;
import dev.patika.libraryManagementSystem.dto.response.category.CategoryResponse;
import dev.patika.libraryManagementSystem.entity.Author;
import dev.patika.libraryManagementSystem.entity.Book;
import dev.patika.libraryManagementSystem.entity.Category;
import dev.patika.libraryManagementSystem.entity.Publisher;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final IBookService bookService;
    private final IModelMapperService modelMapper;
    private final ICategoryService categoryService;
    private final IAuthorService authorService;
    private final IBookBorrowService bookBorrowService;
    private final IPublisherService publisherService;

    public BookController(
            IBookService bookService,
            IModelMapperService modelMapper,
            ICategoryService categoryService,
            IAuthorService authorService,
            IBookBorrowService bookBorrowService,
            IPublisherService publisherService) {

        this.bookService = bookService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookBorrowService = bookBorrowService;
        this.publisherService = publisherService;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest){
        Book saveBook = this.modelMapper.forRequest().map(bookSaveRequest, Book.class);

        Publisher publisher = this.publisherService.get(bookSaveRequest.getPublisherId());
        saveBook.setPublisher(publisher);

        Author author = this.authorService.get(bookSaveRequest.getAuthorId());
        saveBook.setAuthor(author);

        this.bookService.save(saveBook);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBook, BookResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> get(@PathVariable("id") int id){
        Book book = this.bookService.get(id);
        BookResponse bookResponse = this.modelMapper.forResponse().map(book, BookResponse.class);
        return ResultHelper.success(bookResponse);
    }
    @GetMapping("/{id}/category")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> getCategory(@PathVariable("id") int id){
        Book book = this.bookService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(book.getCategoryList(), CategoryResponse.class));
    }
}
