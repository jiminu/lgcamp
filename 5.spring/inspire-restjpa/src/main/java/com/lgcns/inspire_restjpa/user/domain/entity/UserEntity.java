package com.lgcns.inspire_restjpa.user.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.lgcns.inspire_restjpa.blog.domain.entity.BlogEntity;
import com.lgcns.inspire_restjpa.comment.domain.entity.CommentEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
// @ToString(exclude = {"blogs"})
@ToString
public class UserEntity {
    
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Integer id;
    
    @Id // primary key
    private String email; 
    
    @Column(nullable = false, length = 50, unique = true)
    private String passwd;
    @Column(nullable = false, length = 50)
    private String name;
    
    @OneToMany(orphanRemoval = false,
               cascade = CascadeType.ALL,
               mappedBy = "author")
    // @OneToMany(orphanRemoval = false,
    //            mappedBy = "author")
    private List<BlogEntity> blogs = new ArrayList<>();

    // @OneToMany(orphanRemoval = false,
    //            mappedBy = "author")
    // private List<CommentEntity> comments = new ArrayList<>();
}
