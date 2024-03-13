package dev.patika.libraryManagementSystem.dto.request.author;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequest {
    @NotNull(message = "Yazar adı boş olamaz")
    private String name;

    @NotNull(message = "Doğum tarihi boş olamaz")
    private LocalDate birthday;

    @NotNull(message = "Ülke boş olamaz")
    private String country;
}
