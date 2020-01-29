package com.nirley.footballscore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {

    @JsonProperty("country_id")
    String countryId;

    @JsonProperty("league_id")
    String leagueId;

    @JsonProperty("league_name")
    String leagueName;

}
