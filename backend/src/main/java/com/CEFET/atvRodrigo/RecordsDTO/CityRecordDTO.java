package com.CEFET.atvRodrigo.RecordsDTO;

import com.CEFET.atvRodrigo.models.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CityRecordDTO(@NotBlank @Size(max = 30) String name,
                            @NotBlank StateRecordDTO state) {
}
