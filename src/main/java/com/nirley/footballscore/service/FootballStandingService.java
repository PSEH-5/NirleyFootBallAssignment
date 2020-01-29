package com.nirley.footballscore.service;

import com.nirley.footballscore.dto.Country;
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
public class FootballStandingService {

    @Value("${spring.football.api-url}")
    public String url;

    @Value("${spring.football.api-key}")
    public String key;

    @Autowired
    private RestTemplate restTemplate;

    public List<Standing> getStandingByLeagueId(String leagueId) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("action", "get_standings")
                .queryParam("league_id", leagueId)
                .queryParam("APIkey", key);


        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<Standing>>(){}).getBody();


    }

}
