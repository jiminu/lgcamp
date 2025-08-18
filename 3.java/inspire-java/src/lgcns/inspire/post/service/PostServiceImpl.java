package lgcns.inspire.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.repository.PostDAO;

public class PostServiceImpl implements PostService{
    private PostDAO dao;
    
    public PostServiceImpl() {
        dao = new PostDAO();
    }
    

    @Override
    public List<PostResponseDTO> selectService() {
        System.out.println(">>> post select service");
        return dao.selectRow();
    }


    /*
    가져온 데이터로부터 식별값(id)에 만족하는 데이터를 반환
    Stream 사용
     */

    @Override
    public Optional<PostResponseDTO> selectService(int id) {
        System.out.println(">>> post select service id");
        List<PostResponseDTO> list = dao.selectRow();
        
        Optional<PostResponseDTO> result = list.stream()
                                               .filter(post -> post.getId() == id)
                                               .findFirst();

        return result;
    }

    @Override
    public int postService(PostResponseDTO data) {
        
        try {
            dao.insertRow(data);
            return 1;
        } catch(Exception e) {
            return 2;
        }
    }


    @Override
    public List<PostResponseDTO> searchService(String writer) {
        System.out.println(">>>>>>>> search service");
        List<PostResponseDTO> allPosts = dao.selectRow();

        List<PostResponseDTO> posts = allPosts.stream()
                                            .filter(post -> post.getWriter().equals(writer))
                                            .collect(Collectors.toList());
                                   

        return posts;
    }
    
    
}
