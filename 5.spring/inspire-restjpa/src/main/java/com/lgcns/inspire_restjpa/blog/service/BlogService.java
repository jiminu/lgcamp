package com.lgcns.inspire_restjpa.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgcns.inspire_restjpa.blog.domain.dto.BlogRequestDTO;
import com.lgcns.inspire_restjpa.blog.domain.dto.BlogResponseDTO;
import com.lgcns.inspire_restjpa.blog.domain.entity.BlogEntity;
import com.lgcns.inspire_restjpa.blog.repository.BlogRepository;
import com.lgcns.inspire_restjpa.user.domain.entity.UserEntity;
import com.lgcns.inspire_restjpa.user.repository.UserRepository;

@Service
public class BlogService {
    
    @Autowired
    private BlogRepository blogRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public List<BlogResponseDTO> select() {
        System.out.println("[blog service] select");

        List<BlogEntity> entities = blogRepository.findAll();
        
        // return entities.stream()
        //             .map(entity -> BlogResponseDTO.fromEntity(entity))
        //             .toList();
        return entities.stream()
                    .map(entity -> BlogResponseDTO.builder()
                                                  .blogId(entity.getBlogId())
                                                  .title(entity.getTitle())
                                                  .content(entity.getContent())
                                                  .build())
                    .toList();
                     
    }
    
    public BlogResponseDTO insert(BlogRequestDTO request) {
        System.out.println("[db] >>> blog service insert ");
        
        // BlogRequestDTO blogRequest = BlogRequestDTO.builder()
        //                                 .title(request.getTitle())
        //                                 .content(request.getContent())
        //                                 .authorEmail(request.getAuthorEmail())
        //                                 .build();
        Optional<UserEntity> user = userRepository.findById(request.getAuthorEmail());
        BlogEntity blog = blogRepository.save(
            BlogEntity.builder()
            .title(request.getTitle())
            .content(request.getContent())
            .author(user.get())
            .build()
        );
        
        return BlogResponseDTO.fromEntity(blog);
    }
}
