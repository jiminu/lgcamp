package com.lgcns.inspire_spring.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgcns.inspire_spring.test.domain.TestRequestDTO;
import com.lgcns.inspire_spring.test.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api/v1/test")
public class TestCtrl {
    
    @Autowired
    private TestService service;
    
    @GetMapping("/greeting")    
    public void greeting() {
        System.out.println("[debug] >>> testCtrl");
        System.out.println("[debug] >>> service " + service);
        
        TestRequestDTO request = TestRequestDTO.builder()
                                               .emp_id("101")
                                               .email("jh_park@vcc.com")
                                               .build();
        
        System.out.println(service.testService(request));
    }
}
