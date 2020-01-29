package com.nirley.footballscore.service;

import com.nirley.footballscore.dto.Competition;
import com.nirley.footballscore.dto.Country;
import com.nirley.footballscore.dto.Standing;
import com.nirley.footballscore.dto.response.TeamStanding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FootballResultService {

    @Autowired
    FootballCountryService footballCountryService;

    @Autowired
    FootballStandingService footballStandingService;

    @Autowired
    FootballCompetitionService footballCompetitionService;

    public TeamStanding getCountryDetails(String countryName, String leagueName, String teamName) {

        TeamStanding teamStanding = null;
        List<Country> countryList=footballCountryService.getCountryDetails();

        Optional<Country> country = countryList.stream().filter(c->c.getCountryName().equals(countryName)).findFirst();
        if(!country.isPresent()) return teamStanding;

        List<Competition> competitionList=footballCompetitionService.getCompetitionDetailsByCountryId(country.get().getCountryId());
        Optional<Competition> competition = competitionList.stream().filter(c->c.getLeagueName().equals(leagueName)).findFirst();
        if(!competition.isPresent()) return teamStanding;


        List<Standing> standingList = footballStandingService.getStandingByLeagueId(competition.get().getLeagueId());
        Optional<Standing> standing = standingList.stream().filter(s->s.getTeamName().equals(teamName)).findFirst();

        if(!standing.isPresent()) return teamStanding;

        //Move to Mapper
        return TeamStanding.builder()
                .countryId(country.get().getCountryId())
                .countryName(standing.get().getLeagueId())
                .leagueId(standing.get().getLeagueName())
                .leagueName(standing.get().getLeaguePosition())
                .teamId(standing.get().getTeamId())
                .teamName(standing.get().getTeamName())
                .leaguePosition(standing.get().getLeaguePosition())
                .build();

    }

}
