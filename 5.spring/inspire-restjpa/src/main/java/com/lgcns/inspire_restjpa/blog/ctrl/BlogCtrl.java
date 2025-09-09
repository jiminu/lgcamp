package com.lgcns.inspire_restjpa.blog.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.inspire_restjpa.blog.domain.dto.BlogRequestDTO;
import com.lgcns.inspire_restjpa.blog.domain.dto.BlogResponseDTO;
import com.lgcns.inspire_restjpa.blog.service.BlogService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth/api/v2/blog")
public class BlogCtrl {
    
    @Autowired
    private BlogService blogService;
    
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogResponseDTO>> blogs() {
        System.out.println("[debug] >>> blog ctrl path : /blogs");
        
        // String response = "응답문자열";
        // Map<String, String> map = new HashMap<>();
        // map.put("id", "jslim");
        // map.put("email", "jjj@naver.com");
        
        List<BlogResponseDTO> list = blogService.select();
        
        return new ResponseEntity<List<BlogResponseDTO>>(list, HttpStatus.OK);
    }
    
    @PostMapping("/register")
    public ResponseEntity<Void> register(BlogRequestDTO request) {
        
        System.out.println("[debug] >>> blog post : /register");
        System.out.println("[debug] >>> param req   : " + request);
        
        BlogResponseDTO response = blogService.insert(request);
        
        return (response != null) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
    }
    
    @GetMapping("/read/{blogId}")
    public ResponseEntity<BlogResponseDTO> read(@PathVariable("blogId") Integer blogId) {
        System.out.println("[debug] >>> blog get  : /read");
        System.out.println("[debug] >>> blog id   : " + blogId);
        
        BlogResponseDTO response = blogService.findBlog(blogId);
        System.out.println("[debug] >>> response  : " + response);
        
        return (response != null) ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
