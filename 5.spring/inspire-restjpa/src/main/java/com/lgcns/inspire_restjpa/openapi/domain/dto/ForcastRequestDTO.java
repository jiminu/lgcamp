package com.lgcns.inspire_restjpa.openapi.domain.dto;

import lombok.Data;

@Data
public class ForcastRequestDTO {
    
    private String beach_num;
    private String base_date;
    private String base_time;
}
