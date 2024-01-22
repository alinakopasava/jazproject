package com.example.jazik;

import com.example.jazik.dto.HouseDto;
import com.example.jazik.dto.ResultsDto;
import com.example.jazik.model.Head;
import com.example.jazik.model.House;
import com.example.jazik.model.Trait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/houses")
@RestController
public class HouseController {
    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<HouseDto>> getAllHouses() {
        ResultsDto resultsDto = houseService.getAllHouses();
        return new ResponseEntity<>(resultsDto.getHouses(), HttpStatus.OK);
    }

    @GetMapping("gethousebyid{id}")
    public Optional<House> getHouseById(@PathVariable int id) {
        return houseService.getHouseById(id);
    }

    @GetMapping("gethousebyname{name}")
    public Optional<House> getHouseByName(@PathVariable String name) {
        return houseService.getHouseByName(name);
    }

    @GetMapping("getheadbyid{id}")
    public Optional<Head> getHeadById(@PathVariable int id) {
        return houseService.getHeadById(id);
    }

    @GetMapping("gettraitbyid{id}")
    public Optional<Trait> getTraitById(@PathVariable int id) {
        return houseService.getTraitById(id);
    }

    @PostMapping("addhouse")
    public void addHouse(@RequestBody House house) {
        houseService.saveHouse(house);
    }

    @DeleteMapping("/deletehousebyid{id}")
    public void deleteHouseById(@PathVariable(name = "id") int id) {
        houseService.deleteHouseById(id);
    }


    @PutMapping("/updatehousebyid{id}")
    public void deleteHouseById(@PathVariable(name = "id") int id, @RequestBody House house) {
        houseService.updateHouse(id, house);
    }

}