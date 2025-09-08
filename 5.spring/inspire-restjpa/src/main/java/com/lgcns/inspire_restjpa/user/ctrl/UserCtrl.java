package com.lgcns.inspire_restjpa.user.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.inspire_restjpa.user.domain.dto.UserRequestDTO;
import com.lgcns.inspire_restjpa.user.domain.dto.UserResponseDTO;
import com.lgcns.inspire_restjpa.user.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v2/inspire/user")
public class UserCtrl {
    
    @Autowired
    private UserService userService;
    
    
    @PostMapping("signup")
    public ResponseEntity signup(@RequestBody 
                                       @Valid
                                       UserRequestDTO request,
                                       BindingResult bindingResult) {
        
        System.out.println("[db] >>>>> user ctrl sign up : " + request);
        
        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getAllErrors().forEach(error -> {
                FieldError field = (FieldError)error;
                String msg = error.getDefaultMessage();
                System.out.println("[VALIDATION ERROR] -> " + field.getField() + " - " + msg);
                errorMap.put(field.getField(), msg);
            });
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap); 
        }
        
        UserResponseDTO response = userService.signup(request);
        
        if(response != null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            // return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            
        }
        
    }
    
    // 인증 / 인가 : cookie, session, jwt token
    
    // 인증(Authentication) : 누구인지 확인
    // Bearer token - JWT 기반 인증, OAuth2
    // token(accessToken, refreshToken)
    // 응답시(body X , header O) -> Authorization: Bearer <token>

    
    // 인가(Autorization) : 권한 부여 (endpoint에 대한 접근 권한)
    // 요청 시 header 응답 시 전송한 Bearer token 유무 체크, 접근 권한 확인
    @PostMapping("signin")
    public ResponseEntity<UserResponseDTO> signin(@RequestBody UserRequestDTO request) {
        System.out.println("[db] >>>>> user ctrl sign in : " + request);

        Map<String, Object> response = userService.signin(request);

        return ResponseEntity.status(HttpStatus.OK)
                            .header("Authorization", "Bearer "+(String)(response.get("access")))
                            .header("Refresh-Token", (String)(response.get("refresh")))
                            .body((UserResponseDTO)(response.get("response")));

    }
    
    
}
