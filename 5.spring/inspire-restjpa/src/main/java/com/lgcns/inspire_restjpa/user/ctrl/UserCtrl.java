package com.lgcns.inspire_restjpa.user.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.inspire_restjpa.user.domain.dto.UserRequestDTO;
import com.lgcns.inspire_restjpa.user.domain.dto.UserResponseDTO;
import com.lgcns.inspire_restjpa.user.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v2/inspire/user")
public class UserCtrl {
    
    @Autowired
    private UserService userService;
    
    
    @PostMapping("signup")
    public ResponseEntity<Void> signup(@RequestBody UserRequestDTO request) {
        
        System.out.println("[db] >>>>> user ctrl sign up : " + request);
        UserResponseDTO response = userService.signup(request);
        
        // return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    
    // 인증(Authentication) : 누구인지 확인
    // Bearer token - JWT 기반 인증, OAuth2
    // token(accessToken, refreshToken)
    // 응답시(body X , header O) -> Authorization: Bearer <token>

    
    // 인가(Autorization) : 권한 부여 (endpoint에 대한 접근 권한)
    // 요청 시 header 응답 시 전송한 Bearer token 유무 체크, 접근 권한 확인
    @GetMapping("signin")
    public ResponseEntity<UserResponseDTO> signin(@RequestBody UserRequestDTO request) {
        System.out.println("[db] >>>>> user ctrl sign in : " + request);

        UserResponseDTO response = userService.signin(request);

        return ResponseEntity.status(HttpStatus.OK)
                            .body(response);

    }
    
    
}
