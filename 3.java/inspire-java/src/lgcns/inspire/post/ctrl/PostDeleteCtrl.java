package lgcns.inspire.post.ctrl;

import lgcns.inspire.post.service.PostService;
import lgcns.inspire.post.service.PostServiceImpl;

public class PostDeleteCtrl {
    private PostService service;

    public PostDeleteCtrl() {
        service = new PostServiceImpl();
    }
    public PostDeleteCtrl(PostService service) {
        this.service = service;
    }
    
    public boolean delete(int id) {
        System.out.println(">>> delete ctrl id : " + id);

        return true;
    }
}
