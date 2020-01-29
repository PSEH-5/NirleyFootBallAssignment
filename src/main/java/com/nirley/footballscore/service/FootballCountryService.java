package com.nirley.footballscore.service;

import com.nirley.footballscore.dto.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class FootballCountryService {

    @Value("${spring.football.api-url}")
    public String url;

    @Value("${spring.football.api-key}")
    public String key;

    @Autowired
    private RestTemplate restTemplate;

    public List<Country> getCountryDetails() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("action", "get_countries")
                .queryParam("APIkey", key);


        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<Country>>() {
        }).getBody();

    }

}
