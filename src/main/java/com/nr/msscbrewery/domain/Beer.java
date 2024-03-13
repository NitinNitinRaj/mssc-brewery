package com.nr.msscbrewery.domain;

import com.nr.msscbrewery.web.model.v2.BeerStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beer {
    private UUID id;

    private String name;

    private BeerStyle beerStyle;

    private long upc;

    private Timestamp createdDate;
    private Timestamp lastUpdatedDate;
}
