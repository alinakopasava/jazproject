package com.example.jazik;

import com.example.jazik.dto.HouseDto;
import com.example.jazik.dto.ResultsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


//@RequiredArgsConstructor
@Component
public class HouseClient {
    private final RestTemplate restTemplate;

    @Autowired
    public HouseClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ResultsDto getHouses() {
        var url = "https://wizard-world-api.herokuapp.com/Houses";

        ResponseEntity<List<HouseDto>> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<HouseDto>>() {
                });

        ResultsDto resultsDto = new ResultsDto();
        resultsDto.setHouses(responseEntity.getBody());

        return resultsDto;
    }
}