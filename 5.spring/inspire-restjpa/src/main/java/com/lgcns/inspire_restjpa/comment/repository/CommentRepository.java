package com.lgcns.inspire_restjpa.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgcns.inspire_restjpa.comment.domain.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    public List<CommentEntity> findByBlog_BlogId(Integer blogId);

    // @Query("SELECT c FROM CommentEntity c WHERE c.blog.blogId = :blogId")
    // public List<CommentEntity> findByBlog_BlogId(@Param("blogId") Integer
    // blogId);

}
