package com.nr.msscbrewery.web.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    @Null(message = "Dont add id.")
    private UUID id;
    @NotNull(message = "Name should be non null.")
    @Size(min = 3, max = 100, message = "Size of name should be between 3 and 100.")
    private String name;
}
