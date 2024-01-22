package com.example.jazik.mappers;

import com.example.jazik.dto.TraitDto;
import com.example.jazik.model.Trait;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TraitMapper {

    public Trait map(TraitDto traitDto) {
        var trait = new Trait();
        trait.setSourceId(traitDto.getId());
        trait.setName(traitDto.getName());
        return trait;


    }

//    public TraitDto mapToDto(Trait trait) {
//        var traitDto = new TraitDto();
//        traitDto.setId(trait.getSourceId());
//        traitDto.setName(trait.getName());
//        return traitDto;
//
//
//    }

    public List<Trait> mapTraitDtoListToTraitList(List<TraitDto> traitDtos) {
        List<Trait> traits = new ArrayList<>();
        for (TraitDto traitDto : traitDtos) {
            traits.add(map(traitDto));
        }
        return traits;
    }

//    public List<TraitDto> mapTraitListToDtoList(List<Trait> traits) {
//        List<TraitDto> traitDtos = new ArrayList<>();
//        for (Trait trait : traits) {
//            traitDtos.add(mapToDto(trait));
//        }
//        return traitDtos;
//    }
}
