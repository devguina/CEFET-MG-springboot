package com.CEFET.atvRodrigo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class CityDTO {

    private UUID id;

    @Size(max = 100)
    @NotBlank
    @NotNull
    private String name;

    @Size(max = 40)
    @NotBlank
    @NotNull
    @Autowired
    private StateDTO stateDTO;

    public CityDTO (String name, String stateUser, String abbreviationUser){
        this.name = name;
        stateDTO.setName(stateUser);
        stateDTO.setAbbreviation(abbreviationUser);
    }
}
