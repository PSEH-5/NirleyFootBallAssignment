package com.nirley.footballscore.controller.master;

import com.nirley.footballscore.dto.Standing;
import com.nirley.footballscore.service.FootballCountryService;
import com.nirley.footballscore.service.FootballStandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/v1/football-score/standing")
public class FootballStandingController {

    @Autowired
    FootballStandingService footballStandingService;

    @GetMapping("/{leagueId}")
    public List<Standing> getStandingByLeagueId(@PathVariable String leagueId) {
        return footballStandingService.getStandingByLeagueId(leagueId);
    }
}
