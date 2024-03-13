package dev.patika.libraryManagementSystem.dto.request.author;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorUpdateRequest {
    @Positive(message = "ID değeri pozitif olmak zorundadır")
    private int id;

    @NotNull(message = "Yazar adı boş olamaz")
    private String name;

    @NotNull(message = "Doğum tarihi boş olamaz")
    private LocalDate birthday;

    @NotNull(message = "Ülke boş olamaz")
    private String country;
}
