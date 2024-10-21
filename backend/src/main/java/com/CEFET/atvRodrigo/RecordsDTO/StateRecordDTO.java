package com.CEFET.atvRodrigo.RecordsDTO;
import jakarta.validation.constraints.NotBlank;

public record StateRecordDTO(@NotBlank String name,
                             @NotBlank String abbreviation) {
}
