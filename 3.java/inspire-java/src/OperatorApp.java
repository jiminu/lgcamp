import lgcns.inspire.operator.Operator;

public class OperatorApp {
    
    public static void main(String[] args) {
        Operator op = new Operator();
        op.example1();
        
        System.out.println(op.example2("this is str1,", "this is str2"));
    }
}
