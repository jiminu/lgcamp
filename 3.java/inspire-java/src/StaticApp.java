import lgcns.inspire.still.StaticDemo;

public class StaticApp {
    
    public static void main(String[] args) {
        StaticDemo.staticVar = 10;
        System.out.println(StaticDemo.staticVar);
        StaticDemo.staticVar = 100;
        System.out.println(StaticDemo.staticVar);

        System.out.println(StaticDemo.CONST_VAR);
        
        StaticDemo sd = new StaticDemo();
        
        sd.nonStaticMethod();
        sd.staticMethod();
        
    }
}
