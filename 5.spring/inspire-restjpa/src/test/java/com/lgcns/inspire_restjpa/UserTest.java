package com.lgcns.inspire_restjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lgcns.inspire_restjpa.user.domain.dto.UserRequestDTO;
import com.lgcns.inspire_restjpa.user.domain.dto.UserResponseDTO;
import com.lgcns.inspire_restjpa.user.domain.entity.UserEntity;
import com.lgcns.inspire_restjpa.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class UserTest {
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void insertUser() {
        UserRequestDTO request = UserRequestDTO.builder()
                                            .email("test@google.com")
                                            .passwd("1234")
                                            .name("minu")
                                            .build();

        UserEntity entity = userRepository.save(request.toEntity());
        UserResponseDTO response = UserResponseDTO.fromEntity(entity);       
        
        System.out.println("entity : " +  entity);
        System.out.println("dto : " +  response);
        
    }
}
