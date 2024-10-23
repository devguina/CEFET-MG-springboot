package com.CEFET.atvRodrigo.RecordsDTO;

import com.CEFET.atvRodrigo.models.City;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClientRecordDTO(@NotBlank @Size(max = 255) String name,
                              @NotBlank @Size(max = 255) String address,
                              @NotBlank CityRecordDTO city,
                              @NotNull LocalDate birthday,
                              @NotBlank ChildRecordDTO children
                              ){
}
