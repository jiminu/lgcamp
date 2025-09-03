package com.lgcns.inspire_restspring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lgcns.inspire_restspring.rest.comment.domain.CommentRequestDTO;
import com.lgcns.inspire_restspring.rest.comment.service.CommentService;

@SpringBootTest
public class CommentServiceTddTests {
    
    @Autowired
    private CommentService service;
    
    @Test
    public void commentCreateTest() {
        // given
        CommentRequestDTO request = CommentRequestDTO.builder()
                                                     .blog_id(1)
                                                     .content("holllly")
                                                     .build();
        
        
        // when
        // int result = service.insertComment(request);
        
        // then
        // 자동 생성된 pk 가 만들어졌는지
        // assertEquals(1, result);
        // assertNotNull(request);
        
    }
}
