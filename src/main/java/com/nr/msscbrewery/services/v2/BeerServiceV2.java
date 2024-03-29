package com.nr.msscbrewery.services.v2;

import com.nr.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDtoV2 getBeerById(UUID id);

    BeerDtoV2 saveBeer(BeerDtoV2 beerDto);

    void updateBeer(UUID beerId,BeerDtoV2 beerDto);

    void deleteById(UUID beerId);
}
