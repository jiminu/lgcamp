package com.lgcns.inspire_restjpa.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgcns.inspire_restjpa.comment.domain.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    
}
