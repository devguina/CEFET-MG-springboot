package com.CEFET.atvRodrigo.DTO;

import com.CEFET.atvRodrigo.models.Client;
import com.CEFET.atvRodrigo.models.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class CityDto {

    private UUID id;

    @Size(max = 100)
    @NotBlank
    @NotNull
    private String name;

    @Size(max = 40)
    @NotBlank
    @NotNull
    private State state;

    private List<Client> client;
}
