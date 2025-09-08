package com.lgcns.inspire_restjpa.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgcns.inspire_restjpa.user.domain.dto.UserRequestDTO;
import com.lgcns.inspire_restjpa.user.domain.dto.UserResponseDTO;
import com.lgcns.inspire_restjpa.user.domain.entity.UserEntity;
import com.lgcns.inspire_restjpa.user.repository.UserRepository;
import com.lgcns.inspire_restjpa.util.JwtProvider;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JwtProvider provider;
    
    public UserResponseDTO signup(UserRequestDTO request) {
        System.out.println("[user service] sign up");
        
        UserEntity entity = userRepository.save(request.toEntity());
        return UserResponseDTO.fromEntity(entity);
        
    }
    
    public Map<String, Object> signin(UserRequestDTO request) {
        System.out.println("[user service] sign in");
        
        UserEntity entity = userRepository.findByEmailAndPasswd(request.getEmail(), request.getPasswd());
        
        String accToken = provider.generateAccessToken(request.getEmail());
        String refToken = provider.generateRefreshToken(request.getEmail());
        
        System.out.println("[SIGN IN] >>>>>>>>>>>>> accToken : " + accToken);
        
        UserResponseDTO response = UserResponseDTO.fromEntity(entity);
        // response.setAccessToken(accToken);
        // response.setRefreshToken(refToken);
        
        Map<String, Object> map = new HashMap<>();
        map.put("response", response);
        map.put("access", accToken);
        map.put("refresh", refToken);
        
        return map;
    }
}
