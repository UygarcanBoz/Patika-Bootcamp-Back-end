package dev.patika.libraryManagementSystem.dto.request.publisher;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherUpdateRequest {
    @Positive(message = "ID Değeri pozitif olmak zorundadır.")
    private int id;

    @NotNull(message = "Publisher adı boş olamaz")
    private String name;

    @NotNull(message = "Publisher yılı boş olamaz")
    private int establishmentYear;

    @NotNull(message = "Publisher adresi boş olamaz")
    private String address;
}
