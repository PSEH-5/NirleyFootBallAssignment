package com.nirley.footballscore.controller.master;

import com.nirley.footballscore.dto.Country;
import com.nirley.footballscore.service.FootballCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/v1/football-score/country")
public class FootballCountryController {

    @Autowired
    FootballCountryService footballCountryService;

    @GetMapping()
    public List<Country> getCountryList() {
        return footballCountryService.getCountryDetails();
    }
}
