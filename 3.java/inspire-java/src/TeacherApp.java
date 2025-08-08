import lgcns.Teacher;

public class TeacherApp {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher();
        
        System.out.println(teacher1.name);
        System.out.println(teacher1.height);
        System.out.println(teacher1.age);
        System.out.println(teacher1.mbti);
        System.out.println(teacher1.birthPlace);
        System.out.println(teacher1.isMarriage);
        System.out.println("------------------------");
        
        
        Teacher teacher2 = new Teacher("mindu", "ISTJ", "rudrl", 150, 14, false);
        System.out.println(teacher2.name);
        System.out.println(teacher2.height);
        System.out.println(teacher2.age);
        System.out.println(teacher2.mbti);
        System.out.println(teacher2.birthPlace);
        System.out.println(teacher2.isMarriage);
        
    }
}
