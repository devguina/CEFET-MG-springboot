package com.CEFET.atvRodrigo.RecordsDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ChildRecordDTO(@NotBlank @Size(max = 255) String name,
                             @NotNull LocalDate birthday,
                             @NotBlank ClientRecordDTO client) {
}
