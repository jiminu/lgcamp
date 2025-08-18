package lgcns.inspire.post.ctrl;

import java.util.List;
import java.util.Optional;

import lgcns.inspire.post.domain.dto.PostRequestDTO;
import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.service.PostService;
import lgcns.inspire.post.service.PostServiceImpl;

public class PostController {
    
    private PostService service;
    public PostController() {
        service = new PostServiceImpl();
    }
    
    public int post(String title, String content, String writer) {
        List<PostResponseDTO> list = service.selectService();
        int id = list.size() + 1;
        
        PostResponseDTO dto = PostResponseDTO.builder()
                                             .id(id)
                                             .title(title)
                                             .content(content)
                                             .writer(writer)
                                             .build();
        
        return service.postService(dto);
    }
    
    
    public List<PostResponseDTO> list() {
        System.out.println(">>> post ctrl list");
        return service.selectService();
    }
    
    public Optional<PostResponseDTO> findPost(int id) {
        System.out.println(">>> controller find post");
        return service.selectService(id);
    }
}
