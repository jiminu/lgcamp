package lgcns.inspire.game;

import java.util.Scanner;

public class GuessGame {
    
    public static int generatorNan() {
        return (int)(Math.random() * 100) + 1;
    }
    
    public String gameStart(int answer) {
        Scanner scan = new Scanner(System.in);
        
        for (int i = 1; i <= 10; ++i) {
            System.out.print(i + "번 째 정답을 입력하세요. : ");
            int guess = scan.nextInt();
            System.out.printf("당신의 선택은 %d 입니다. \n", guess);
            
            if (guess < answer) {
                System.out.println("업");
            }
            else if (guess > answer) {
                System.out.println("다운");
            }
            else {
                scan.close();
                return i + "번 째 정답을 맞췄습니다.";
            }
        }
        
        scan.close();
        return "10번의 기회를 모두 사용하였습니다.";
    }
}
