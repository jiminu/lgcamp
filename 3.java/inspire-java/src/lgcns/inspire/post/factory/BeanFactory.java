package lgcns.inspire.post.factory;

import java.util.HashMap;
import java.util.Map;

import lgcns.inspire.post.ctrl.PostDeleteCtrl;
import lgcns.inspire.post.ctrl.PostFindCtrl;
import lgcns.inspire.post.ctrl.PostInsertCtrl;
import lgcns.inspire.post.ctrl.PostListCtrl;
import lgcns.inspire.post.ctrl.PostSaveCtrl;
import lgcns.inspire.post.ctrl.PostSearchCtrl;
import lgcns.inspire.post.ctrl.PostUpdateCtrl;
import lgcns.inspire.post.service.PostService;
import lgcns.inspire.post.service.PostServiceImpl;

/*
Singleton Pattern
- 인스턴스를 하나로 유지하는 방법 (무분별한 객체 생성 방지) : Inversion of Controll (IOC)
- 문법)
    - 생성자의 접근제어자는 private
    - 자신의 타입을 반환하는 메서드 static으로 생성

 */

public class BeanFactory {
    private static BeanFactory instance;

    private Map<String, Object> map;

    private PostService service;

    private BeanFactory() {
        map     = new HashMap<>();
        service = new PostServiceImpl();
        map.put("list", new PostListCtrl(service));
        map.put("find", new PostFindCtrl(service));
        map.put("insert", new PostInsertCtrl(service));
        map.put("delete", new PostDeleteCtrl(service));
        map.put("update", new PostUpdateCtrl(service));
        map.put("search", new PostSearchCtrl(service));
        map.put("save", new PostSaveCtrl(service));
    }

    public static BeanFactory getInstance() {
        if (instance == null) {
            instance = new BeanFactory();
        }

        return instance;

    }

    public Object getCtrl(String requestURI) {
        return map.get(requestURI);
    }
}
