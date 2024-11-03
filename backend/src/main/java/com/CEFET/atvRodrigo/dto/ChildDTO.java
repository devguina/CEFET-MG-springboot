package com.CEFET.atvRodrigo.dto;


import com.CEFET.atvRodrigo.models.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ChildDTO {

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
    private ClientDTO clientDTO;


    public ChildDTO() {
    }

    // construtor para usar para atualziar o pai do filho sem precisar passar outros dados
    public ChildDTO(ClientDTO clientDTO) {
        clientDTO.setName(clientDTO.getName());
    }
}
