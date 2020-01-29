package com.nirley.footballscore.controller.master;

import com.nirley.footballscore.dto.Competition;
import com.nirley.footballscore.dto.Country;
import com.nirley.footballscore.service.FootballCompetitionService;
import com.nirley.footballscore.service.FootballCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/football-score/competition")
public class FootballCompetitionController {

    @Autowired
    FootballCompetitionService footballCompetitionService;

    @GetMapping("/{countryId}")
    public List<Competition> getCompetitionDetails(@PathVariable String countryId) {
        return footballCompetitionService.getCompetitionDetailsByCountryId(countryId);
    }
}
