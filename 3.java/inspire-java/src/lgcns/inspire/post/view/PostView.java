package lgcns.inspire.post.view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import lgcns.inspire.post.ctrl.PostController;
import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.front.FrontController;

public class PostView {
    
    private Scanner scan;
    
    // private PostController ctrl;
    private FrontController front;
    
    public PostView() {
        scan = new Scanner(System.in);
        // ctrl = new PostController();
        front = new FrontController();
    }
    
    public void mainMenu() {
        outer:
        while (true) {
            System.out.println(">>> Inspire Camp Post Ver 1");
            System.out.println("1.  전체검색");
            System.out.println("2.  게시글 상세 보기");
            System.out.println("3.  입력 폼으로 이동");
            System.out.println("4.  수정 페이지 이동");
            System.out.println("5.  삭제");
            System.out.println("6.  게시글 작성자로 검색");
            System.out.println("99. 프로그램 종료");
            System.out.print("번호를 입력하세요 : ");
            int number = Integer.parseInt(scan.nextLine());
            
            switch (number) {
                case 1:
                    list();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    insert();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    findByWriter();
                    break;
                case 99:
                    System.out.println("종료");
                    // System.exit(0);
                    break outer;
            
                default:
                    System.out.println("선택한 번호는 없는 번호입니다.");
                    break;
            }
        }
    }
    
    public void list() {
        System.out.println(">>> 데이터 출력");
        
        List<PostResponseDTO> list = front.list("list");
        System.out.println(">> view list : " + list);
        
        // list.stream()
        //     .map(PostResponseDTO::getTitle)
        //     .forEach(System.out::println);
            
        // list.stream()
        //     .filter(post -> post.getId() >= 2)
        //     .forEach(System.out::println);
        
        
        System.out.println();
    }
    
    public void read() {
        System.out.println();
        System.out.println(">>> 게시물 찾기 <<<");
        System.out.print("id를 입력하세요 : ");
        int id = Integer.parseInt(scan.nextLine());
        
        Optional<PostResponseDTO> result = front.findPost("find", id);
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("존재하지 않는 id 입니다.");
        }
    }
    
    public void findByWriter() {
        System.out.println();
        System.out.println(">>> 작성자 게시물 찾기 <<<");
        System.out.print("작성자를 입력하세요 : ");
        String writer = scan.nextLine();
        
        List<PostResponseDTO> result = front.findById("search", writer);
        
        System.out.println(result);

    }
    
    public void insert() {
        System.out.println();
        System.out.println(">>> title, content, writer");
        System.out.print("제목을 입력하세요 : ");
        String title = scan.nextLine();
        System.out.print("내용을 입력하세요 : ");
        String content = scan.nextLine();
        System.out.print("작성자를 입력하세요 : ");
        String writer = scan.nextLine();
        
        int result = front.insert("insert", title, content, writer);
        
        if (result == 1) {
            System.out.println("정상적으로 post 되었습니다.");
        }
        else if (result ==2) {
            System.out.println("post 할 수 없습니다.");
        }
    }
    
    public void delete() {
        System.out.println();
        System.out.println(">>> 게시물 삭제 <<<");
        System.out.print("id를 입력하세요 : ");
        int id = Integer.parseInt(scan.nextLine());
        
        boolean result = front.delete("delete", id);

        System.out.println(result ? "삭제 완료" : "삭제 실패");
    }
    
    public void update() {
        System.out.println();
        System.out.println(">>> 게시물 업데이트 <<<");
        System.out.print("id를 입력하세요 : ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.print("수정할 제목을 입력하세요 : ");
        String title = scan.nextLine();
        System.out.print("수정할 내용을 입력하세요 : ");
        String content = scan.nextLine();
        
        int result = front.update("update", title, content, id);
        
        if (result == 1) {
            System.out.println("수정 완료");
        }
        else {
            System.out.println("수정 실패");
        }
    }
}
