package com.CEFET.atvRodrigo.RecordsDTO;

import jakarta.validation.constraints.NotBlank;

public record CityRecordDTO(@NotBlank String name,
                            @NotBlank String state) {
}
