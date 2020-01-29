package com.nirley.footballscore.controller.api;

import com.nirley.footballscore.dto.response.TeamStanding;
import com.nirley.footballscore.service.FootballResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/football-score/score")
public class FootballResultController {


    @Autowired
    FootballResultService footballResultService;

    @GetMapping("/{countryName}/{leagueName}/{teamName}")
    public TeamStanding getLeagueStanding(@PathVariable String countryName, @PathVariable String leagueName, @PathVariable String teamName) {

        return footballResultService.getCountryDetails(countryName,leagueName,teamName);

    }
}
