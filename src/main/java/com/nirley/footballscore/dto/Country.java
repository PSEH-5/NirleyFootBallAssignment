package com.nirley.footballscore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @JsonProperty("country_id")
    String countryId;

    @JsonProperty("country_name")
    String countryName;

}
