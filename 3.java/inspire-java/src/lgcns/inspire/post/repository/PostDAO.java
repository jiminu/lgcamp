package lgcns.inspire.post.repository;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        
        posts = fileLoad("./test.txt");
        
        // posts = new ArrayList<>(Arrays.asList(
        //         PostResponseDTO.builder()
        //                 .id(1)
        //                 .title("mvc")
        //                 .content("first content")
        //                 .writer("jslim")
        //                 .build(),
        //         PostResponseDTO.builder()
        //                 .id(2)
        //                 .title("wow")
        //                 .content("second content")
        //                 .writer("jslim")
        //                 .build(),
        //         PostResponseDTO.builder()
        //                 .id(3)
        //                 .title("ggyak")
        //                 .content("third content")
        //                 .writer("holy")
        //                 .build(),
        //         PostResponseDTO.builder()
        //                 .id(4)
        //                 .title("springboot")
        //                 .content("pattern combination")
        //                 .writer("inspire~")
        //                 .build()
        // ));
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
    public int updateRow(PostResponseDTO request) {
        System.out.println(">>> update row");
        
        // for (int i = 0; i < posts.size(); ++i ) {
        //     PostResponseDTO post = posts.get(i);
            
        //     if (post.getId() == request.getId()) {
        //         post.setTitle(request.getTitle());
        //         post.setContent(request.getContent());
        //     }
        // }
        
        posts.stream()
             .filter(post -> post.getId() == request.getId())
             .peek(post -> {
                 post.setTitle(request.getTitle()); 
                 post.setContent(request.getContent()); 
                 })
             .forEach(post -> {});
        
        // posts.stream()
        //      .filter(post -> post.getId() == request.getId())
        //      .findFirst()
        //      .ifPresent(post -> {
        //          post.setTitle(request.getTitle());
        //          post.setContent(request.getContent());
        //      });
        
        return 0;
    }
    
    // D(삭제)
    public int deleteRow(Map<String, Integer> map) {
        System.out.println(">>> delete row");
        
        // Optional<PostResponseDTO> deleteTarget = posts.stream()
        //                                               .filter(post -> post.getId() == map.get("key"))
        //                                               .findFirst();
        
        boolean result = posts.removeIf(post -> post.getId() == map.get("key"));
        
        return result ? 1 : 0;
        
    }
    
    public List<PostResponseDTO> fileLoad(String path) {
        List<PostResponseDTO> response = null;
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            response = (List<PostResponseDTO>)ois.readObject();
            System.out.println(">>> 불러오기 완료");
        }
        catch(Exception e) {
            response = new ArrayList<>();
            System.out.println(">>> 불러오기 실패");
            // e.printStackTrace();
        }
        
        return response;        
    }
}
