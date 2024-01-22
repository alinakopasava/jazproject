package com.example.jazik.mappers;

import com.example.jazik.dto.HeadDto;
import com.example.jazik.model.Head;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HeadMapper  {

    public Head map(HeadDto headDto) {
        var head = new Head();
        head.setFirstName(headDto.getFirstName());
        head.setLastName(headDto.getLastName());
        head.setSourceId(headDto.getId());
        return head;
    }

//    public HeadDto mapToDto(Head head) {
//        var headDto = new HeadDto();
//        headDto.setFirstName(head.getFirstName());
//        headDto.setLastName(head.getLastName());
//        headDto.setId(head.getSourceId());
//        return headDto;
//    }


    public List<Head> mapHeadDtoListToHeadList(List<HeadDto> headDtos) {
        List<Head> heads = new ArrayList<>();
        for (HeadDto headDto : headDtos) {
            heads.add(map(headDto));
        }
        return heads;
    }

//    public List<HeadDto> mapHeadListToDtoList(List<Head> heads) {
//        List<HeadDto> headDtos = new ArrayList<>();
//        for (Head heads1 : heads) {
//            headDtos.add(mapToDto(heads1));
//        }
//        return headDtos;
//    }
}
