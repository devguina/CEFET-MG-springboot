package com.CEFET.atvRodrigo.dto;

import com.CEFET.atvRodrigo.models.Child;
import com.CEFET.atvRodrigo.models.City;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class ClientDTO {

    private UUID id;

    @NotBlank
    @NotNull
    @Size(max = 255)
    private String name;

    @NotBlank
    @NotNull
    @Size(max = 255)
    private String address;


    @NotBlank
    @NotNull
    @Size(max = 100)
    private City city;

    private boolean active = true;

    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy") //formatado para nosso padrão
    private LocalDate birthday;

    private List<Child> children;

    //construtor para usar para adicionar um filho em um usuário existente
    public ClientDTO (ChildDTO childDTO){
        childDTO.setId(childDTO.getId());
        childDTO.setName(childDTO.getName());
        childDTO.setBirthday(childDTO.getBirthday());
    }
}
