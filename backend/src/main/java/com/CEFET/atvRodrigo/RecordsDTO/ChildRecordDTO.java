package com.CEFET.atvRodrigo.RecordsDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ChildRecordDTO(@NotBlank String name,
                             @NotNull LocalDate birthday,
                             @NotBlank String client) {
}