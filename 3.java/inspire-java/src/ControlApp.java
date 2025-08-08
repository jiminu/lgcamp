import lgcns.inspire.control.ControlDemo;

public class ControlApp {
    
    public static void main(String[] args) {
        // int axe = 2;
        // System.out.println(cd.woodMan(axe));
        // System.out.println(cd.woodManSwitch(axe));
        // System.out.println(cd.woodManTernary(axe));
        ControlDemo cd = new ControlDemo();
        
        System.out.println(cd.passOrNonpass(30, 100, 100));
        
    }
}
