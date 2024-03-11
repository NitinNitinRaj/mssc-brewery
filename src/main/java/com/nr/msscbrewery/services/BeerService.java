package com.nr.msscbrewery.services;

import com.nr.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID id);

    BeerDto saveBeer(BeerDto beerDto);

    void updateBeer(UUID beerId,BeerDto beerDto);

    void deleteById(UUID beerId);
}
