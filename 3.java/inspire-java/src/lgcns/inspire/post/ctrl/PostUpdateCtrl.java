package lgcns.inspire.post.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        
        Map<String, Object> map = new HashMap<>();
        map.put("key", id);
        map.put("title", title);
        map.put("content", content);
        
        PostResponseDTO dto = PostResponseDTO.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
        
        return service.updateService(dto);
        
    }

}
