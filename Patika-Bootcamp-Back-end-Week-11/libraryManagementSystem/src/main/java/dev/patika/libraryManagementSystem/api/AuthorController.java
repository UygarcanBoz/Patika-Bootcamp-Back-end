package dev.patika.libraryManagementSystem.api;

import dev.patika.libraryManagementSystem.business.abstracts.IAuthorService;
import dev.patika.libraryManagementSystem.core.config.modelMapper.IModelMapperService;
import dev.patika.libraryManagementSystem.core.result.Result;
import dev.patika.libraryManagementSystem.core.result.ResultData;
import dev.patika.libraryManagementSystem.core.utilies.ResultHelper;
import dev.patika.libraryManagementSystem.dto.CursorResponse;
import dev.patika.libraryManagementSystem.dto.request.author.AuthorSaveRequest;
import dev.patika.libraryManagementSystem.dto.request.author.AuthorUpdateRequest;
import dev.patika.libraryManagementSystem.dto.response.author.AuthorResponse;
import dev.patika.libraryManagementSystem.entity.Author;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    private final IAuthorService authorService;
    private final IModelMapperService modelMapperService;

    public AuthorController(IAuthorService authorService, IModelMapperService modelMapperService) {
        this.authorService = authorService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest){
        Author saveCategory = this.modelMapperService.forRequest().map(authorSaveRequest, Author.class);
        this.authorService.save(saveCategory);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveCategory, AuthorResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> get(@PathVariable("id") int id){
        Author category = this.authorService.get(id);
        AuthorResponse categoryResponse = this.modelMapperService.forResponse().map(category, AuthorResponse.class);
        return ResultHelper.success(categoryResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AuthorResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize){

        Page<Author> categoryPage = this.authorService.cursor(page,pageSize);
        Page<AuthorResponse> categoryResponsePage = categoryPage
                .map(category -> this.modelMapperService.forResponse().map(category, AuthorResponse.class));
        return ResultHelper.cursor(categoryResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update(@Valid @RequestBody AuthorUpdateRequest categoryUpdateRequest){
        this.authorService.get(categoryUpdateRequest.getId());
        Author updateAuthor = this.modelMapperService.forRequest().map(categoryUpdateRequest, Author.class);
        this.authorService.update(updateAuthor);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateAuthor, AuthorResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.authorService.delete(id);
        return ResultHelper.ok();
    }
}
