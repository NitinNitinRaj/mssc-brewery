package com.nr.msscbrewery.web.controller.v2;

import com.nr.msscbrewery.services.BeerService;
import com.nr.msscbrewery.services.v2.BeerServiceV2;
import com.nr.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private  final BeerServiceV2 beerService;


    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
            return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> handlePost(@RequestBody  BeerDtoV2 beerDto){
        BeerDtoV2 savedDto  = beerService.saveBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        //ToDo add hostname to url
        headers.add("Location","/api/v2/beer/"+savedDto.getId().toString());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<HttpStatus> handleUpdate(@RequestBody BeerDtoV2 beerDto,@PathVariable("beerId") UUID beerId){
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHandle(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }
}
