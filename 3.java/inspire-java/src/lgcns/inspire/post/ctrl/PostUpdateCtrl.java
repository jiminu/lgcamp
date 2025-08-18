package lgcns.inspire.post.ctrl;

import java.util.List;
import java.util.Optional;

import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.service.PostService;
import lgcns.inspire.post.service.PostServiceImpl;

public class PostUpdateCtrl {
    private PostService service;

    public PostUpdateCtrl() {
        service = new PostServiceImpl();
    }
    public PostUpdateCtrl(PostService service) {
        this.service = service;
    }

    public int update(String title, String content, int id) {
        Optional<PostResponseDTO> post = service.selectService(id);
        
        if (post.isPresent()) {
            
            return 1;
        }
        else {
            return 0;
        }
    }

}
