package lgcns.inspire.post.repository;

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
    
    // C
    public int insertRow(PostRequestDTO req) {
        System.out.println(">>> insert row");
        return 0;
    }   
    
    // R(전체)
    public List<PostResponseDTO> selectRow() {
        System.out.println(">>> select row");
        return null;
    } 

    // R(조건)
    public PostResponseDTO selectRow(String id) {
        System.out.println(">>> select row id");
        return null;
    }
    
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
