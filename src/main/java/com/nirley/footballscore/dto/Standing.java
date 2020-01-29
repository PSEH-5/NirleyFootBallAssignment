package com.nirley.footballscore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Standing {

    @JsonProperty("country_name")
    String countryName;

    @JsonProperty("league_id")
    String leagueId;

    @JsonProperty("league_name")
    String leagueName;

    @JsonProperty("team_id")
    String teamId;

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("overall_league_position")
    String leaguePosition;

}
