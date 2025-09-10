package com.lgcns.inspire_restjpa.openapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgcns.inspire_restjpa.openapi.domain.dto.ForcastResponseDTO;
import com.lgcns.inspire_restjpa.openapi.util.ForcastItems;

@Service
public class ForcastService {
    
    public List<ForcastResponseDTO> parsingJson(String data) {
        System.out.println("[DEBUG] parsing json ");
        ObjectMapper mapper = new ObjectMapper();
        List<ForcastResponseDTO> list = null;
        
        try {
            ForcastItems items = mapper.readValue(data, ForcastItems.class);
            list = items.getItems();
            System.out.println("[DEBUG] forcast service result : ");
            list.stream()
                .forEach(System.out::println);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
