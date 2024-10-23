package com.CEFET.atvRodrigo.RecordsDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRecordDTO(@NotBlank @Size(max=200)String name,
                            @NotBlank @Size(max=30) String login,
                            @NotBlank @Size(max = 30) String password) {
}
