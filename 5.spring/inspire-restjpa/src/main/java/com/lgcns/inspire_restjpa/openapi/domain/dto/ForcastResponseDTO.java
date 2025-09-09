package com.lgcns.inspire_restjpa.openapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class ForcastResponseDTO {
    
    @JsonProperty("beachNum")
    private String beachNum;
    
    @JsonProperty("baseDate")
    private String baseDate;
    
    @JsonProperty("baseTime")
    private String baseTime;

    @JsonProperty("category")
    private String category;
    
}
