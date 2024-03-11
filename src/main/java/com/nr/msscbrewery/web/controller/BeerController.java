package com.nr.msscbrewery.web.controller;

import com.nr.msscbrewery.services.BeerService;
import com.nr.msscbrewery.web.model.BeerDto;
import com.nr.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private  final BeerService beerService;


    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
            return new  ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> handlePost(@RequestBody  BeerDto beerDto){
        BeerDto savedDto  = beerService.saveBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        //ToDo add hostname to url
        headers.add("Location","/api/v1/beer/"+savedDto.getId().toString());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<HttpStatus> handleUpdate(@RequestBody BeerDto beerDto,@PathVariable("beerId") UUID beerId){
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHandle(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }
}
