import lgcns.inspire.generic.ErrorCode;

public class GenericApp {
    
    public static void main(String[] args) {
        ErrorCode<Integer> err = new ErrorCode<>();
        err.setCode(400);
        System.out.println(err.getCode());
        
        
    }
}
