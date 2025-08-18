package lgcns.inspire.post.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lgcns.inspire.post.domain.dto.PostRequestDTO;
import lgcns.inspire.post.domain.dto.PostResponseDTO;

/*
    DAO ( Data Access Object )
    - db와의 작업을 담당하는 클래스
    - 입력(C), 읽기(R), 수정(U), 삭제(D) : CRUD
    - Structure Query Language (SQL): DDL, DML, DCL, Select Query

 */

public class PostDAO {
    
    private List<PostResponseDTO> posts;
    
    public PostDAO() {
        posts = new ArrayList<>(Arrays.asList(
                PostResponseDTO.builder()
                        .id(1)
                        .title("mvc")
                        .content("first content")
                        .writer("jslim")
                        .build(),
                PostResponseDTO.builder()
                        .id(2)
                        .title("wow")
                        .content("second content")
                        .writer("jslim")
                        .build(),
                PostResponseDTO.builder()
                        .id(3)
                        .title("ggyak")
                        .content("third content")
                        .writer("holy")
                        .build(),
                PostResponseDTO.builder()
                        .id(4)
                        .title("springboot")
                        .content("pattern combination")
                        .writer("inspire~")
                        .build()
        ));
    }
    
    // C(생성)
    public int insertRow(PostResponseDTO req) {
        System.out.println(">>> insert row");
        
        try {
            posts.add(req);
            return 1;
        } catch(Exception e) {
            return 2;
        }
    }   
    
    // R(전체)
    public List<PostResponseDTO> selectRow() {
        System.out.println(">>> select row");
        
        return posts;
    } 

    // R(조건)
    // public PostResponseDTO selectRow(String id) {
    //     System.out.println(">>> select row id");
    //     return null;
    // }
    
    // U(수정)
    public int updateRow(PostRequestDTO req) {
        System.out.println(">>> update row");
        return 0;
    }
    
    // D(삭제)
    public int deleteRow(String id) {
        System.out.println(">>> delete row");
        return 0;
        
    }
}
