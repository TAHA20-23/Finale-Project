package com.example.tuwaiqfinalproject.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class FieldDTO {
    @NotEmpty(message = "Field name must not be empty")
    private String name;

    @NotEmpty(message = "Address must not be empty")
    private String address;

    @NotEmpty(message = "Description must not be empty")
    private String description;

    @NotNull(message = "Open time must not be null")
    private LocalTime open_time;

    @NotNull(message = "Close time must not be null")
    private LocalTime close_time;

    @NotNull(message = "capacity must not be empty")
    @Min(value = 2)
    @Max(value = 22)
    private Integer capacity;

    @NotNull
    @PositiveOrZero
    private Double price;
}
