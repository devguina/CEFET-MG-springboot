package com.CEFET.atvRodrigo.RecordsDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StateRecordDTO(@NotBlank @Size(max = 25) String name,
                             @NotBlank @Size(max = 2) String abbreviation) {
}
