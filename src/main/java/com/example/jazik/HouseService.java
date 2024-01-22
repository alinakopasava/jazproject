package com.example.jazik;

import com.example.jazik.dto.HouseDto;
import com.example.jazik.dto.ResultsDto;
import com.example.jazik.mappers.HouseMapper;
import com.example.jazik.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private final HouseClient houseClient;
    private final HouseRepository houseRepository;
    private final HeadRepository headRepository;
    private final TraitRepository traitRepository;
    private final HouseMapper houseMapper;

    public HouseService(HouseClient houseClient, HouseRepository houseRepository, HeadRepository headRepository, TraitRepository traitRepository, HouseMapper houseMapper) {
        this.houseClient = houseClient;
        this.houseRepository = houseRepository;
        this.headRepository = headRepository;
        this.traitRepository = traitRepository;
        this.houseMapper = houseMapper;
    }

    public ResultsDto getAllHouses() {
        saveToDatabase();
        return houseClient.getHouses();

    }

    public Optional<House> getHouseById(int id) {
        return houseRepository.findById(id);

    }

    public Optional<Head> getHeadById(int id) {
        return headRepository.findById(id);

    }

    public Optional<Trait> getTraitById(int id) {
        return traitRepository.findById(id);
    }

    public Optional<House> getHouseByName(String name) {
        return houseRepository.findByName(name);

    }

    public void saveHouse(House house) {
        houseRepository.save(house);
    }

    public void deleteHouseById(int id) {
        houseRepository.deleteById(id);
    }

    public void updateHouse(int id, House house) {
        Optional<House> existingHouseOptional = houseRepository.findById(id);

        if (existingHouseOptional.isPresent()) {
            House existingHouse = existingHouseOptional.get();

            existingHouse.setName(house.getName());
            existingHouse.setSourceId(house.getSourceId());
            existingHouse.setHouseColours(house.getHouseColours());
            existingHouse.setFounder(house.getFounder());
            existingHouse.setAnimal(house.getAnimal());
            existingHouse.setElement(house.getElement());
            existingHouse.setGhost(house.getGhost());
            existingHouse.setCommonRoom(house.getCommonRoom());
            existingHouse.setHeads(house.getHeads());
            existingHouse.setTraits(house.getTraits());
            houseRepository.save(existingHouse);
        } else {

            throw new NotFoundException();
        }
    }

        public void saveToDatabase() {
            ResultsDto resultsDto = houseClient.getHouses();
            List<HouseDto> housesDto = resultsDto.getHouses();

            List<House> houses = new ArrayList<>();

            for (HouseDto houseDto : housesDto) {
                houses.add(houseMapper.map(houseDto));
            }

            for (House house : houses) {
                if (!houseRepository.existsBySourceId(house.getSourceId())) {
                    houseRepository.save(house);
                }
            }
        }
}


