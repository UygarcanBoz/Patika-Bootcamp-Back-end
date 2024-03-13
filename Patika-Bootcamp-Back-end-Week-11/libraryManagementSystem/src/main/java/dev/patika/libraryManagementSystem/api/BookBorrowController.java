package dev.patika.libraryManagementSystem.api;

import dev.patika.libraryManagementSystem.business.abstracts.IBookBorrowService;
import dev.patika.libraryManagementSystem.business.abstracts.IBookService;
import dev.patika.libraryManagementSystem.core.config.modelMapper.IModelMapperService;
import dev.patika.libraryManagementSystem.core.result.Result;
import dev.patika.libraryManagementSystem.core.result.ResultData;
import dev.patika.libraryManagementSystem.core.utilies.ResultHelper;
import dev.patika.libraryManagementSystem.dto.CursorResponse;
import dev.patika.libraryManagementSystem.dto.request.bookBorrow.BookBorrowSaveRequest;
import dev.patika.libraryManagementSystem.dto.request.bookBorrow.BookBorrowUpdateRequest;
import dev.patika.libraryManagementSystem.dto.response.bookborrow.BookBorrowResponse;
import dev.patika.libraryManagementSystem.entity.Book;
import dev.patika.libraryManagementSystem.entity.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookborrows")
public class BookBorrowController {
    private final IBookBorrowService bookBorrowService;
    private final IBookService bookService;
    private final IModelMapperService modelMapper;

    public BookBorrowController(IBookBorrowService bookBorrowService, IBookService bookService, IModelMapperService modelMapper) {
        this.bookBorrowService = bookBorrowService;
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowResponse> save(@Valid @RequestBody BookBorrowSaveRequest bookBorrowSaveRequest){
        BookBorrowing saveBookBorrow = this.modelMapper.forRequest().map(bookBorrowSaveRequest, BookBorrowing.class);

        Book book = this.bookService.get(bookBorrowSaveRequest.getBookId());
        saveBookBorrow.setBook(book);

        this.bookBorrowService.save(saveBookBorrow);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBookBorrow, BookBorrowResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowResponse> get(@PathVariable("id") int id){
        BookBorrowing bookBorrowing = this.bookBorrowService.get(id);
        BookBorrowResponse bookBorrowResponse = this.modelMapper.forResponse().map(bookBorrowing, BookBorrowResponse.class);
        return ResultHelper.success(bookBorrowResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookBorrowResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize){

        Page<BookBorrowing> bookBorrowingPage = this.bookBorrowService.cursor(page,pageSize);
        Page<BookBorrowResponse> bookBorrowResponsePage = bookBorrowingPage
                .map(bookBorrowing -> this.modelMapper.forResponse().map(bookBorrowing, BookBorrowResponse.class));
        return ResultHelper.cursor(bookBorrowResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowResponse> update(@Valid @RequestBody BookBorrowUpdateRequest bookBorrowUpdateRequest){
        this.bookBorrowService.get(bookBorrowUpdateRequest.getId());
        BookBorrowing updateBookBorrow = this.modelMapper.forRequest().map(bookBorrowUpdateRequest, BookBorrowing.class);
        this.bookBorrowService.update(updateBookBorrow);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateBookBorrow, BookBorrowResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.bookBorrowService.delete(id);
        return ResultHelper.ok();
    }

    @GetMapping("/getAll")
    public List<BookBorrowing> getAll(){
        return bookBorrowService.getAll();
    }
}
