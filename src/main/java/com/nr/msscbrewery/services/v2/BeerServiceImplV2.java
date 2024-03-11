package com.nr.msscbrewery.services.v2;

import com.nr.msscbrewery.services.BeerService;
import com.nr.msscbrewery.web.model.v2.BeerDtoV2;
import com.nr.msscbrewery.web.model.v2.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID id) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).name("Galaxy Cat").beerStyle(BeerStyle.PISLSNER).upc(1234456889).build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
    }

    @Override
    public void deleteById(UUID beerId) {
    log.debug("Deleting beer with Id: "+beerId);
    }
}
