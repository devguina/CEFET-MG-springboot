package com.CEFET.atvRodrigo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class UserDTO {

    private UUID id;

    @NotBlank
    @NotNull
    @Size(max = 255)
    private String name;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String login;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String password;

    private boolean active;

}
