import lgcns.Student;

public class studentApp {
    public static void main(String[] args) {

        Student instance = new Student();

        System.out.println(instance);
        System.out.println(instance.name);
        System.out.println(instance.gender);
        
        instance.name = "mindu";
        instance.gender = 'F';
        
        System.out.println(instance.name);
        System.out.println(instance.gender);

    }
}
