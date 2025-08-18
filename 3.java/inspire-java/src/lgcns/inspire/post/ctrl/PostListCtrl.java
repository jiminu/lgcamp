package lgcns.inspire.post.ctrl;

import java.util.List;

import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.service.PostService;
import lgcns.inspire.post.service.PostServiceImpl;

public class PostListCtrl {
    private PostService service;
    public PostListCtrl() {
        service = new PostServiceImpl();
    }
    public PostListCtrl(PostService service) {
        System.out.println(">>>> postListCtrl parameter constructor");
        this.service = service;
    }
    
    public List<PostResponseDTO> list() {
        System.out.println(">>> post ctrl list");
        return service.selectService();
    }
}
