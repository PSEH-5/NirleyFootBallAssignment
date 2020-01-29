package com.nirley.footballscore.service;

import com.nirley.footballscore.dto.Competition;
import com.nirley.footballscore.dto.Standing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class FootballCompetitionService {


    @Value("${spring.football.api-url}")
    public String url;

    @Value("${spring.football.api-key}")
    public String key;


    @Autowired
    private RestTemplate restTemplate;

    public List<Competition> getCompetitionDetailsByCountryId(String countryId) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept",  MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("action", "get_leagues")
                .queryParam("country_id", countryId)
                .queryParam("APIkey", key);

        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<Competition>>(){})
                .getBody();


    }

}
