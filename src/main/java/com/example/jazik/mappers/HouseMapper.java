package com.example.jazik.mappers;

import com.example.jazik.dto.HeadDto;
import com.example.jazik.dto.HouseDto;
import com.example.jazik.dto.TraitDto;
import com.example.jazik.model.Head;
import com.example.jazik.model.House;
import com.example.jazik.model.Trait;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HouseMapper {
    private final HeadMapper headMapper;
    private final TraitMapper traitMapper;

    public HouseMapper(HeadMapper headMapper, TraitMapper traitMapper) {
        this.headMapper = headMapper;
        this.traitMapper = traitMapper;
    }

    public House map(HouseDto houseDTO) {
        var house = new House();
        house.setSourceId(houseDTO.getId());
        house.setName(houseDTO.getName());
        house.setHouseColours(houseDTO.getHouseColours());
        house.setFounder(houseDTO.getFounder());
        house.setAnimal(houseDTO.getAnimal());
        house.setElement(houseDTO.getElement());
        house.setGhost(houseDTO.getGhost());
        house.setCommonRoom(houseDTO.getCommonRoom());
        List<Head> heads = headMapper.mapHeadDtoListToHeadList(houseDTO.getHeads());
        house.setHeads(heads);
        List<Trait> traits = traitMapper.mapTraitDtoListToTraitList(houseDTO.getTraits());
        house.setTraits(traits);
        return house;
    }

//    public HouseDto maptoDto(House house) {
//        var houseDto = new HouseDto();
//        houseDto.setId(house.getSourceId());
//        houseDto.setName(house.getName());
//        houseDto.setHouseColours(house.getHouseColours());
//        houseDto.setFounder(house.getFounder());
//        houseDto.setAnimal(house.getAnimal());
//        houseDto.setElement(house.getElement());
//        houseDto.setGhost(house.getGhost());
//        houseDto.setCommonRoom(house.getCommonRoom());
//        List<HeadDto> headDtos = headMapper.mapHeadListToDtoList(house.getHeads());
//        houseDto.setHeads(headDtos);
//        List<TraitDto> traitDtos = traitMapper.mapTraitListToDtoList(house.getTraits());
//        houseDto.setTraits(traitDtos);
//        return houseDto;
//    }
}
