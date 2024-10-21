package com.CEFET.atvRodrigo.RecordsDTO;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(@NotBlank String name,
                            @NotBlank String login,
                            @NotBlank String password) {
}
