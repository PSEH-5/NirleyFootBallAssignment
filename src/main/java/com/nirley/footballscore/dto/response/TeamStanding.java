package com.nirley.footballscore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamStanding {

    String countryName;

    String countryId;

    String leagueId;

    String leagueName;

    String teamId;

    String teamName;

    String leaguePosition;
}
