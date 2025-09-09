package com.lgcns.inspire_restjpa.blog.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lgcns.inspire_restjpa.comment.domain.entity.CommentEntity;
import com.lgcns.inspire_restjpa.user.domain.entity.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"comments"})
public class BlogEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;
    
    @Column(nullable = false,
            length = 150)
    private String title;
    
    @Column(nullable = false,
            length = 1000)
    private String content;
    
    // foreign key
    @ManyToOne(fetch = FetchType.LAZY,
               optional = false)
    @JoinColumn(name = "author_email") // 테이블 컬럼 이름
    private UserEntity author;          // UserEntity 의 mappedBy
    
    @OneToMany(orphanRemoval = true, // 블로그가 삭제된다면 (parents) 댓글도 다 삭제 (child) 
               cascade = CascadeType.ALL,
               mappedBy = "blog")
    @JsonManagedReference
    private List<CommentEntity> comments = new ArrayList<>();
    
}
