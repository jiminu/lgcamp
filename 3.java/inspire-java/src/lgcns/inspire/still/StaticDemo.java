package lgcns.inspire.still;

public class StaticDemo {
    public int nonStaticVar;
    public static int staticVar;
    
    public static final int CONST_VAR = 10;
    
    public void nonStaticMethod() {
        System.out.println("This is a non-static method.");
        
        nonStaticVar = 11;
        staticVar = 11;
        
        int sum = nonStaticVar + staticVar;
        
        System.out.println("sum = " + sum);
        
    }
    
    public static void staticMethod() {
        System.out.println("This is a static method.");
        staticVar = 11;
        
        
        System.out.println("sum = " + staticVar);
    }
}

