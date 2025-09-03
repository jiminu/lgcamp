package com.lgcns.inspire_restspring.rest.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogRequestDTO;
import com.lgcns.inspire_restspring.rest.blog.domain.BlogResponseDTO;
import com.lgcns.inspire_restspring.rest.blog.repository.BlogMapper;
import com.lgcns.inspire_restspring.rest.comment.domain.CommentResponseDTO;
import com.lgcns.inspire_restspring.rest.comment.repository.CommentMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {

    @Autowired
    private CommentMapper commentMapper;

    private final BlogMapper blogMapper;

    public List<BlogResponseDTO> select() {
        
        System.out.println("[db] >>> blog service select ");
        
        return blogMapper.selectRow();
    }
    
    public int insert(BlogRequestDTO request) {
        System.out.println("[db] >>> blog service insert ");
        
        return blogMapper.insertRow(request);
    }
    
    @Transactional
    public BlogResponseDTO findById(int id) {
        System.out.println("[db] >>> blog service findById ");
        BlogResponseDTO blog = blogMapper.findById(id);
        List<CommentResponseDTO> list = commentMapper.selectRow(blog.getId());
        
        // System.out.println("[db] >>>>>>>>>>>>>> " + list);
        
        blog.setComments(list);
        
        System.out.println("[db] >>>>>>>>>>>>>> " + blog.getComments());
        
        return blog;
    }
    
    public List<BlogResponseDTO> findByKeyword(String keyword) {
        System.out.println("[db] >>> blog service findByKeyword ");
        
        return blogMapper.findByKeyword(keyword);
    }
    
    public int update(BlogRequestDTO request) {
        System.out.println("[db] >>> blog service update ");
        
        return blogMapper.updateRow(request);
    }
    
    public int delete(int id) {
        System.out.println("[db] >>> blog service delete ");
        
        return blogMapper.deleteById(id);
    }
}