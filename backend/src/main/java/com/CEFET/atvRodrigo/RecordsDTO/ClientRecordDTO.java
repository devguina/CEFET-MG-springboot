package com.CEFET.atvRodrigo.RecordsDTO;

import com.CEFET.atvRodrigo.models.City;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClientRecordDTO(@NotBlank String name,
                              @NotBlank String address,
//                              @NotBlank String city,
                              @NotNull LocalDate birthday
//                              @NotBlank String children
                              ){
}
