package lgcns.inspire.post.ctrl;

import java.util.List;

import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.service.PostService;
import lgcns.inspire.post.service.PostServiceImpl;

public class PostSearchCtrl {
    private PostService service;

    public PostSearchCtrl() {
        service = new PostServiceImpl();
    }

    public PostSearchCtrl(PostService service) {
        System.out.println(">>>> postSearchCtrl parameter constructor");
        this.service = service;
    }

    public List<PostResponseDTO> search(String writer) {
        System.out.println(">>> controller find post");
        return service.searchService(writer);
    }
}
