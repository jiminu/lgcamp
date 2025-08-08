public class VariableApp {
    
    public static void main(String[] args) {
        int     age       = 20;
        float   height    = 150;
        char    gender    = 'M';
        String  name      = "minwoo";
        boolean isBoolean = true;

        System.out.println(age);
        System.out.println(height);
        System.out.println(gender);
        System.out.println(isBoolean);
        
        byte x = 10, y = 10, sum = 0;

        sum = (byte)(x+y);

        System.out.println(sum);

        char charVar01 = 'A', charVar02 = 'B';
        System.out.println(charVar01+charVar02);
        System.out.println((char)97);

        double doubleVar = 10.4;
    }
}
