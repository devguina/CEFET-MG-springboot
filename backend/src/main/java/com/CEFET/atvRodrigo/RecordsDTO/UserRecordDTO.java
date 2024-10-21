package com.CEFET.atvRodrigo.RecordsDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordDTO(@NotBlank String name,
                            @NotBlank String login,
                            @NotBlank String password,
                            @NotNull boolean active) {
}
