package com.nr.msscbrewery.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {

    @Null(message = "Id Should be null.")
    private UUID id;

    @NotBlank(message = "Beer Name should not be blank.")
    private String name;

    @NotBlank(message = "Beer Style should be specified.")
    private String beerStyle;

    @Positive(message = "IPC value should be positive.")
    @NotNull(message = "IPC must not be blank")
    private long upc;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;


}
