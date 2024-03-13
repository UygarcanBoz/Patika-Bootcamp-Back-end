package dev.patika.libraryManagementSystem.dto.request.publisher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherSaveRequest {
    @NotNull(message = "Publisher adı boş olamaz")
    private String name;

    @NotNull(message = "Publisher yılı boş olamaz")
    private int establishmentYear;

    @NotNull(message = "Publisher adresi boş olamaz")
    private String address;
}
