package com.lgcns.inspire_restspring.rest.comment.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogRequestDTO;
import com.lgcns.inspire_restspring.rest.comment.domain.CommentRequestDTO;
import com.lgcns.inspire_restspring.rest.comment.domain.CommentResponseDTO;
import com.lgcns.inspire_restspring.rest.comment.service.CommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.Resources;

@RestController
@RequestMapping("/api/v1/blog/comment")
@Tag(name= "Blog Comment API", description = "댓글 관련 명세서")
public class CommentCtrl {
    
    @Resource(name="cs_ver")
    private CommentService service;
    
    @Operation(
        summary = "댓글 입력", 
        description = "blog id와 댓글을 입력받아 데이터베이스에 등록합니다."
    )
    @PostMapping("/register")
    public ResponseEntity<List<CommentResponseDTO>> register(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "댓글 정보 전달 받음.")
        @RequestBody CommentRequestDTO request) {
        
        System.out.println("[debug] >>> comment ctrl post : /register");
        System.out.println("[debug] >>> param req   : " + request);
        
        List<CommentResponseDTO> result = service.insertComment(request);
        
        return (result != null) ? new ResponseEntity<>(result, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
        
        // if (result != null) {
        //     return ResponseEntity.status(HttpStatus.CREATED).body(result);
        // }
        // else {
        //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        // }
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id ) {
        System.out.println("[debug] >>> comment ctrl delete : /delete/{id}");
        System.out.println("[debug] >>> id                  : " + id);
        
        int result = service.deleteComment(id);
        
        if (result != 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
