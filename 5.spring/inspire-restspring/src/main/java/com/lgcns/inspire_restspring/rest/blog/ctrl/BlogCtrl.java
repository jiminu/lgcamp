package com.lgcns.inspire_restspring.rest.blog.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogRequestDTO;
import com.lgcns.inspire_restspring.rest.blog.domain.BlogResponseDTO;
import com.lgcns.inspire_restspring.rest.blog.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


/*
HTTP 통신 client 가 웹서버에게(WAS-tomcat) 요청의 목적을 알리는 수단
- Get, Post, Delete, Put, Patch

요청 - 응답 템플릿
- RequestEntity, ResponseEntity
 */


@RestController
@RequestMapping("/api/v1/blog")
@Tag(name= "Blog API", description = "블로그 관련 API 명세서")
public class BlogCtrl {
    
    @Autowired
    private BlogService service;
    
    
    @Operation(
        summary = "블로그 전체 조회",
        description = "특정 블로그가 아닌 블로그 전체를 조회합니다."
    )
    @ApiResponses(
        {
            @ApiResponse(responseCode = "200",
                         description = "전체조회성공"),
            @ApiResponse(responseCode = "404",
                         description = "전체조회실패")
        }
    )
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogResponseDTO>> blogs() {
        System.out.println("[debug] >>> blog ctrl path : /blogs");
        
        // String response = "응답문자열";
        // Map<String, String> map = new HashMap<>();
        // map.put("id", "jslim");
        // map.put("email", "jjj@naver.com");
        
        List<BlogResponseDTO> list = service.select();
        
        return new ResponseEntity<List<BlogResponseDTO>>(list, HttpStatus.OK);
    }
    

    // @PostMapping("/register")
    // public ResponseEntity<Void> register(
    //     @Parameter(description = "title, content 입력")
    //     @RequestParam("title") String title,
    //     @RequestParam("content") String content) {
        
    //     System.out.println("[debug] >>> blog post : /register");
    //     System.out.println("[debug] >>> param title   : " + title);
    //     System.out.println("[debug] >>> param content : " + content);
        
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
    
    @Operation(
        summary = "블로그 입력", 
        description = "타이틀과 컨텐츠를 입력받아 데이터베이스에 등록합니다."
    )
    @PostMapping("/register")
    public ResponseEntity<Void> register(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "생성할 블로그 정보 전달 받음.")
        @RequestBody BlogRequestDTO request) {
        
        System.out.println("[debug] >>> blog post : /register");
        System.out.println("[debug] >>> param req   : " + request);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    @Operation(
        summary = "블로그 상세보기", 
        description = "블로그 id로 특정 블로그 검색")
    @GetMapping("/read/{id}")
    public ResponseEntity<BlogResponseDTO> read(
        @Parameter(description = "조회할 블로그 id")
        @PathVariable("id") int id) {
        System.out.println("[debug] >>> blog read ");
        System.out.println("[debug] >>> id : " + id);
        
        BlogResponseDTO response = null;
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
    @PutMapping("update/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") int id, 
                                @RequestBody BlogRequestDTO request) {
        System.out.println("[debug] >>> blog ctrl PUT path : /update/{id}");
        System.out.println("[debug] >>> id : " + id);
        System.out.println("[debug] >>> dto : " + request);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }   
    
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        System.out.println("[debug] >>> blog ctrl DELETE path : /delete/{id}");
        System.out.println("[debug] >>> id : " + id);
        
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
