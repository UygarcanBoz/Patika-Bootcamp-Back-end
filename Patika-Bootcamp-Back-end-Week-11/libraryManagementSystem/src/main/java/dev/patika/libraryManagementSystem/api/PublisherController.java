package dev.patika.libraryManagementSystem.api;

import dev.patika.libraryManagementSystem.business.abstracts.IPublisherService;
import dev.patika.libraryManagementSystem.core.config.modelMapper.IModelMapperService;
import dev.patika.libraryManagementSystem.core.result.Result;
import dev.patika.libraryManagementSystem.core.result.ResultData;
import dev.patika.libraryManagementSystem.core.utilies.ResultHelper;
import dev.patika.libraryManagementSystem.dao.PublisherRepo;
import dev.patika.libraryManagementSystem.dto.CursorResponse;
import dev.patika.libraryManagementSystem.dto.request.category.CategorySaveRequest;
import dev.patika.libraryManagementSystem.dto.request.publisher.PublisherSaveRequest;
import dev.patika.libraryManagementSystem.dto.request.publisher.PublisherUpdateRequest;
import dev.patika.libraryManagementSystem.dto.response.category.CategoryResponse;
import dev.patika.libraryManagementSystem.dto.response.publisher.PublisherResponse;
import dev.patika.libraryManagementSystem.entity.Category;
import dev.patika.libraryManagementSystem.entity.Publisher;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final IPublisherService publisherService;
    private final IModelMapperService modelMapperService;

    public PublisherController(IPublisherService publisherService, IModelMapperService modelMapperService) {
        this.publisherService = publisherService;
        this.modelMapperService = modelMapperService;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest){
        Publisher savePublisher = this.modelMapperService.forResponse().map(publisherSaveRequest, Publisher.class);
        this.publisherService.save(savePublisher);
        return ResultHelper.created(this.modelMapperService.forResponse().map(savePublisher, PublisherResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> get(@PathVariable("id") int id){
        Publisher publisher = this.publisherService.get(id);
        PublisherResponse publisherResponse = this.modelMapperService.forResponse().map(publisher, PublisherResponse.class);
        return ResultHelper.success(publisherResponse);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<PublisherResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<Publisher> publisherPage = this.publisherService.cursor(page, pageSize);
        Page<PublisherResponse> publisherResponsePage = publisherPage.map(publisher -> this.modelMapperService.forResponse().map(publisher, PublisherResponse.class));
        return ResultHelper.cursor(publisherResponsePage);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest){
        this.publisherService.get(publisherUpdateRequest.getId());
        Publisher updatePublisher = this.modelMapperService.forResponse().map(publisherUpdateRequest, Publisher.class);
        this.publisherService.update(updatePublisher);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updatePublisher, PublisherResponse.class));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.publisherService.delete(id);
        return ResultHelper.ok();
    }
}
