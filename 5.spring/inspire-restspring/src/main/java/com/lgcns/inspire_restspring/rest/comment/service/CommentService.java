package com.lgcns.inspire_restspring.rest.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogResponseDTO;
import com.lgcns.inspire_restspring.rest.blog.repository.BlogMapper;
import com.lgcns.inspire_restspring.rest.comment.domain.CommentRequestDTO;
import com.lgcns.inspire_restspring.rest.comment.domain.CommentResponseDTO;
import com.lgcns.inspire_restspring.rest.comment.repository.CommentMapper;

import jakarta.transaction.Transactional;

@Service("cs_ver")
public class CommentService {
    
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private BlogMapper blogMapper;
    
    // 데이터베이스 작업의 논리적 단위로 하나로 묶어서
    // 전부 성공 (commit) 또는 전부 실패(rollback)
    // 일부 commit 이나 일부 rollback 은 불가능
    @Transactional
    public List<CommentResponseDTO> insertComment(CommentRequestDTO request) {
        System.out.println("[db] >>> commentService insertRow");
        
        List<CommentResponseDTO> result = null;
        BlogResponseDTO blog = blogMapper.findById(request.getBlog_id());

        if(blog != null) {
            int flag = commentMapper.insertRow(request);
            
            if (flag == 1) {
                result = commentMapper.selectRow(request.getBlog_id());
            }
            
        }
        else {
            throw new RuntimeException("blog not found");
        }
        return result;
    }
    
    
    public int deleteComment(int id) {
        System.out.println("[db] >>> comment service delete");
        
        return commentMapper.deleteRow(id);
    }
}
