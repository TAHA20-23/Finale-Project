package com.example.tuwaiqfinalproject.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchSlotRequestDTO {

    @NotNull
    private Integer fieldId;

    @NotEmpty
    private List<Integer> slotIds;
}
