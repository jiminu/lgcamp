package lgcns.inspire.post.ctrl;

import java.util.List;

import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.service.PostService;
import lgcns.inspire.post.service.PostServiceImpl;

public class PostInsertCtrl {
    private PostService service;

    public PostInsertCtrl() {
        service = new PostServiceImpl();
    }
    public PostInsertCtrl(PostService service) {
        this.service = service;
    }

    public int insert(String title, String content, String writer) {
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
}
