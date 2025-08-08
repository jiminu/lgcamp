package lgcns.inspire.control;

public class ControlDemo {
    
    
    public String woodMan(int axe) {
        String result = "";
        /*
         * 조건) 매개변수의 값이 1 ~ 3
         * 조건) 1 : 금도끼 , 2 : 은도끼 , 3 : 쇠도끼
         * 조건) 나무꾼이 제 도끼는 1번입니다라고 한다면? -> '거짓말을 하는구나' 메시지를 반환
         * 조건) 나무꾼이 제 도끼는 2번입니다라고 한다면? -> '또 거짓말을 하는구나' 메시지를 반환
         * 조건) 나무꾼이 제 도끼는 3번입니다라고 한다면? -> '정직하구나 너에게 모든 도기를 주겠다' 메시지를 반환
         */
        
        System.out.println("산신령이 묻는다. 너의 도끼는 무어냐? (1~3)");
         
        if (axe == 1) {
            result = "거짓말을 하는구나";
        }
        else if (axe == 2) {
            result = "또 거짓말을 하는구나";
        }
        else if (axe == 3) {
            result = "정직하구나 너에게 모든 도기를 주겠다";
        }
        else {
            result = "없는 도끼다.";
        }
         
        return result;
    }
                          
    public String woodManSwitch(int axe) {
        String result = "";
        /*
         * 조건) 매개변수의 값이 1 ~ 3
         * 조건) 1 : 금도끼 , 2 : 은도끼 , 3 : 쇠도끼
         * 조건) 나무꾼이 제 도끼는 1번입니다라고 한다면? -> '거짓말을 하는구나' 메시지를 반환
         * 조건) 나무꾼이 제 도끼는 2번입니다라고 한다면? -> '또 거짓말을 하는구나' 메시지를 반환
         * 조건) 나무꾼이 제 도끼는 3번입니다라고 한다면? -> '정직하구나 너에게 모든 도기를 주겠다' 메시지를 반환
         */
        
        System.out.println("산신령이 묻는다. 너의 도끼는 무어냐? (1~3)");
        
        switch (axe) {
            case 1:
                result = "거짓말을 하는구나";
                break;
                
            case 2:
                result = "또 거짓말을 하는구나";
                break;
                
            case 3:
                result = "정직하구나 너에게 모든 도기를 주겠다";
                break;
                
            default:
                result = "없는 도끼다.";
                break;
        }
         
        return result;
    }
                          
    public String woodManTernary(int axe) {
        String result = "";
        /*
         * 조건) 매개변수의 값이 1 ~ 3
         * 조건) 1 : 금도끼 , 2 : 은도끼 , 3 : 쇠도끼
         * 조건) 나무꾼이 제 도끼는 1번입니다라고 한다면? -> '거짓말을 하는구나' 메시지를 반환
         * 조건) 나무꾼이 제 도끼는 2번입니다라고 한다면? -> '또 거짓말을 하는구나' 메시지를 반환
         * 조건) 나무꾼이 제 도끼는 3번입니다라고 한다면? -> '정직하구나 너에게 모든 도기를 주겠다' 메시지를 반환
         */
        
        System.out.println("산신령이 묻는다. 너의 도끼는 무어냐? (1~3)");
        
        result = (axe == 1) ? "거짓말을 하는구나" : 
                 (axe == 2) ? "또 거짓말을 하는구나" :
                 (axe == 3) ? "정직하구나 너에게 모든 도기를 주겠다" :
                              "없는 도끼다.";
         
        return result;
    }
                          

    public String passOrNonpass(int kor, int eng, int math) {
        /*
         * Quiz)
         * paramter : kor, eng, math
         * return type : String
         * method name : passOrNonpass
         * 합격의 조건)
         * - 세 과목의 점수가 각각 40점이상이면서
         * - 평균 60점 이상이면 합격
         * - 아니면 불합격
         */
         
        if (kor >= 40 && 
            eng >= 40 && 
            math >= 40 && 
            (kor+eng+math)/3 >= 60) return "pass";
        
        return "nonpass";
    }
}
