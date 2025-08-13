package lgcns.inspire.post.view;

import java.util.Scanner;

public class PostView {
    
    private Scanner scan;
    
    public PostView() {
        scan = new Scanner(System.in);
    }
    
    public void mainMenu() {
        outer:
        while (true) {
            System.out.println(">>> Inspire Camp Post Ver 1");
            System.out.println("1.  전체검색");
            System.out.println("2.  키워드검색");
            System.out.println("3.  입력 폼으로 이동");
            System.out.println("4.  수정 페이지 이동");
            System.out.println("5.  삭제");
            System.out.println("99. 프로그램 종료");
            System.out.print("번호를 입력하세요 : ");
            int number = scan.nextInt();
            
            switch (number) {
                case 1:
                    list();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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
    }
}
