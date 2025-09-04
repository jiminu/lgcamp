package com.lgcns.inspire_restjpa.user.service;

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
    
    public UserResponseDTO signin(UserRequestDTO request) {
        System.out.println("[user service] sign in");
        
        UserEntity entity = userRepository.findByEmailAndPasswd(request.getEmail(), request.getPasswd());
        
        String accToken = provider.generateAccessToken(request.getEmail());
        String refToken = provider.generateRefreshToken(request.getEmail());
        
        UserResponseDTO response = UserResponseDTO.fromEntity(entity);
        response.setAccessToken(accToken);
        response.setRefreshToken(refToken);
        
        return response;
    }
}
