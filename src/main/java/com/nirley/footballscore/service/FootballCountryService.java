package com.nirley.footballscore.service;

import com.nirley.footballscore.dto.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class FootballCountryService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Country> getCountryDetails() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl("https://apiv2.apifootball.com")
                .queryParam("action", "get_countries")
                .queryParam("APIkey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");


        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<Country>>() {
        }).getBody();

    }

}
