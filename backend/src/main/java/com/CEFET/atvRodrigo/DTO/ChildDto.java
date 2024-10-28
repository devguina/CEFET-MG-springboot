package com.CEFET.atvRodrigo.DTO;


import com.CEFET.atvRodrigo.models.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ChildDto {

    private UUID id;

    @Size(max = 255)
    @NotBlank
    @NotNull
    private String name;

    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy") //formatado para nosso padrão
    private LocalDate birthday;

    @NotNull
    @NotBlank
    private Client client;

}
