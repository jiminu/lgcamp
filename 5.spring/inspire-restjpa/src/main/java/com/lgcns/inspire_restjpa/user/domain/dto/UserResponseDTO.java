package com.lgcns.inspire_restjpa.user.domain.dto;

import com.lgcns.inspire_restjpa.user.domain.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDTO {
    private String email;
    private String passwd;
    private String name;
    
    // token
    // private String accessToken;
    // private String refreshToken;
    
    
    // static factory method pattern
    // entity -> dto
    
    public static UserResponseDTO fromEntity(UserEntity entity) {
        return UserResponseDTO.builder()
                        .email(entity.getEmail())
                        .passwd(entity.getPasswd())
                        .name(entity.getName())
                        .build();
    }
}
