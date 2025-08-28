package com.lgcns.inspire_restspring.rest.blog.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogResponseDTO;

@Mapper
public interface BlogMapper {
    
    public List<BlogResponseDTO> selectRow();
}
