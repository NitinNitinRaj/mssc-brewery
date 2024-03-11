package com.nr.msscbrewery.services;

import com.nr.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements  BeerService{
    @Override
    public BeerDto getBeerById(UUID id) {
        return BeerDto.builder().id(UUID.randomUUID()).name("Galaxy Cat").beerStyle("Pale Ale").upc(1234456889).build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
    }

    @Override
    public void deleteById(UUID beerId) {
    log.debug("Deleting beer with Id: "+beerId);
    }
}
