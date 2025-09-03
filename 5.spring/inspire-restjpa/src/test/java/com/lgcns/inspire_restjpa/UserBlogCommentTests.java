package com.lgcns.inspire_restjpa;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.lgcns.inspire_restjpa.blog.domain.dto.BlogRequestDTO;
import com.lgcns.inspire_restjpa.blog.domain.entity.BlogEntity;
import com.lgcns.inspire_restjpa.blog.repository.BlogRepository;
import com.lgcns.inspire_restjpa.comment.domain.dto.CommentRequestDTO;
import com.lgcns.inspire_restjpa.comment.domain.entity.CommentEntity;
import com.lgcns.inspire_restjpa.comment.repository.CommentRepository;
import com.lgcns.inspire_restjpa.user.domain.dto.UserRequestDTO;
import com.lgcns.inspire_restjpa.user.domain.dto.UserResponseDTO;
import com.lgcns.inspire_restjpa.user.domain.entity.UserEntity;
import com.lgcns.inspire_restjpa.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserBlogCommentTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    /*
     * 로그인 한 사용자가 블로그를 작성 (author)
     * comment 작성 (blog)
     * blog 조회 시 -> user and comment 연관관계 검증
     * 댓글 삭제 시 ->
     */

    @Test
    @Transactional
    @Commit
    public void user_blog_comment() {
        // 1. 회원가입 -> 로그인
        String email = "test@google.com";
        String passwd = "1234";
        String name = "minu";
        
        UserRequestDTO request = UserRequestDTO.builder()
                .email(email)
                .passwd(passwd)
                .name(name)
                .build();

        userRepository.save(request.toEntity());
        
        UserEntity findUser = userRepository.findByEmailAndPasswd(request.getEmail(), request.getPasswd());
        UserResponseDTO userResponse = UserResponseDTO.fromEntity(findUser);
        System.out.println("로그인 성공");
        System.out.println(">>>>>>>>>>>>>>>>>>" + userResponse);
        
        // 2. 블로그 작성
        BlogRequestDTO blogRequest = BlogRequestDTO.builder()
                                        .title("jpa")
                                        .content("contetete")
                                        .authorEmail("test@google.com")
                                        .build();
        Optional<UserEntity> user = userRepository.findById(blogRequest.getAuthorEmail());
        BlogEntity blog = blogRepository.save(
            BlogEntity.builder()
            .title(blogRequest.getTitle())
            .content(blogRequest.getContent())
            .author(user.get())
            .build()
        );
        
        // 3. 다른 사용자가 댓글 작성.
        CommentRequestDTO commentRequest = CommentRequestDTO.builder()
                                                        .blogId(1)
                                                        .comment("댓글이랍니당")
                                                        .build();
                                                        
        BlogEntity findBlog = blogRepository
                                    .findById(commentRequest.getBlogId())
                                    .orElseThrow(() -> new RuntimeException("error~"));
        
        CommentEntity comment = commentRepository.save(
            CommentEntity.builder()
            .comment("commmm~ent")
            .blog(findBlog)
            .build()
        );
    }
}