package com.nr.msscbrewery.web.model.v2;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDtoV2 {

    @Null(message = "Id Should be null.")
    private UUID id;

    @NotBlank(message = "Beer Name should not be blank.")
    private String name;

    @NotNull(message = "Beer Style should be specified.")
    private BeerStyle beerStyle;

    @Positive
    @NotNull(message = "IPC value should be positive.")
    private long upc;
}

