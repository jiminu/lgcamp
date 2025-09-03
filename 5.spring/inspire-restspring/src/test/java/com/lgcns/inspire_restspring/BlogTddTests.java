package com.lgcns.inspire_restspring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogRequestDTO;
import com.lgcns.inspire_restspring.rest.blog.domain.BlogResponseDTO;
import com.lgcns.inspire_restspring.rest.blog.repository.BlogMapper;

@SpringBootTest
public class BlogTddTests {
    
    @Autowired
    private BlogMapper mapper;
    
    // @BeforeEach
    // public void init() {
        // given 전 데이터 삽입
    // }
    
    
    // TDD - red (failing test) : 블로그 등록 기능
    @Test
    public void blogInsertTest() {
        
        // given
        BlogRequestDTO request = BlogRequestDTO.builder()
                                                .title("holy")
                                                .content("moly")
                                                .build();

        // when
        int flag = mapper.insertRow(request);
        System.out.println("[db] >>> flag : " + flag);
        System.out.println("[db] >>> id : " + request.getId());
        
        // then
        assertEquals(1, flag);
        assertNotNull(request.getId());
        
        
    }
    
    @Test
    public void blogUpdateTest() {
        // given
        BlogRequestDTO request = BlogRequestDTO.builder()
                                                .id(5)
                                                .title("holy 5")
                                                .content("moly 5")
                                                .build();
        
        // when
        int flag = mapper.updateRow(request);
        System.out.println("[db] >>> update flag : " + flag);
        
        // then
        assertEquals(1, flag);
        BlogResponseDTO response = mapper.findById(request.getId());
        assertEquals(request.getTitle(), response.getTitle());
        assertEquals(request.getContent(), response.getContent());
        System.out.println("request title : " + request.getTitle());
        System.out.println("response title : " + response.getTitle());
    }
    
    @Test
    public void blogListTest() {
        // given
        // X
        
        
        // when
        List<BlogResponseDTO> response = mapper.selectRow();
        
        // then
        // 검증포인트: 조회결과가 null 이 아님
        // stream: 필터링을 통한 검증
        
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertTrue(response.size() >= 3);

        // 무결성
        assertTrue(response.stream()
                           .allMatch(blog -> blog.getTitle() != null));
    }
    
    @Test
    public void blogDeleteTest() {
        // given
        int id = 5;
        
        // when
        int flag = mapper.deleteById(id);
        System.out.println("[db] >>> delete flag : " + flag);
        
        // then
        // 삭제된 row 확인, 삭제 후 다시 조회 시 null, 전체 row 줄어드는 거
        
        BlogResponseDTO response = mapper.findById(id);
        assertNull(response);
        
    }
    
    @Test
    public void findByKeyword() {
        String keyword = "다";
        
        List<BlogResponseDTO> response = mapper.findByKeyword(keyword);
        
        
        assertNotNull(response);
        assertFalse(response.isEmpty());
        response.stream()
                .forEach(System.out::println);
    }
}
