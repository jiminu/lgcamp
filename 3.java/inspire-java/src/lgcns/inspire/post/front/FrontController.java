package lgcns.inspire.post.front;

import java.util.List;
import java.util.Optional;

import lgcns.inspire.post.ctrl.PostDeleteCtrl;
import lgcns.inspire.post.ctrl.PostFindCtrl;
import lgcns.inspire.post.ctrl.PostInsertCtrl;
import lgcns.inspire.post.ctrl.PostListCtrl;
import lgcns.inspire.post.ctrl.PostSaveCtrl;
import lgcns.inspire.post.ctrl.PostSearchCtrl;
import lgcns.inspire.post.ctrl.PostUpdateCtrl;
import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.factory.BeanFactory;
import lgcns.inspire.post.service.PostService;
import lgcns.inspire.post.service.PostServiceImpl;

public class FrontController {
    
    private BeanFactory factory;
    
    public FrontController() {
        factory = BeanFactory.getInstance();
    }

    public List<PostResponseDTO> list(String requestURL) {
        System.out.println(">>> front ctrl list");
        PostListCtrl obj = (PostListCtrl)factory.getCtrl(requestURL);
        
        return obj.list();
    }

    public int insert(String requestURL, String title, String content, String writer) {
        System.out.println(">>> front post ");
        
        PostInsertCtrl obj = (PostInsertCtrl)factory.getCtrl(requestURL);

        return obj.insert(title, content, writer);
    }

    public Optional<PostResponseDTO> findPost(String requestURL, int id) {
        System.out.println(">>> front find post");
        
        PostFindCtrl obj = (PostFindCtrl)factory.getCtrl(requestURL);
        
        return obj.findPost(id);
    }
    
    public int delete(String requestURL, int id) {
        System.out.println(">>> front delete");
        
        PostDeleteCtrl obj = (PostDeleteCtrl)factory.getCtrl(requestURL);

        return obj.delete(id);
    }
    
    public int update(String requestURL, String title, String content, int id) {
        System.out.println(">>> front update");
        
        PostUpdateCtrl obj = (PostUpdateCtrl)factory.getCtrl(requestURL);

        return obj.update(title, content, id);
    }
    
    public List<PostResponseDTO> findById(String requestURL, String writer) {
        System.out.println(">>> front find by id");

        PostSearchCtrl obj = (PostSearchCtrl) factory.getCtrl(requestURL);

        return obj.search(writer);
        
    }
    
    public int save(String requestURL, String path) {
        System.out.println(">>> front save");

        PostSaveCtrl obj = (PostSaveCtrl)factory.getCtrl(requestURL);
        
        return obj.save(path);
        
    }
}