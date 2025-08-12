import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.sub.StudentDTO;
import lgcns.inspire.inheritance.sub.TeacherDTO;

public class ArgPolyApp {

    private static PersonDTO[] perAry = new PersonDTO[10];
    private static int idx;

    public static void main(String[] args) {
        TeacherDTO tea = TeacherDTO.builder()
                .name("imim")
                .age(20)
                .addr("seuol")
                .subject("java")
                .build();
        StudentDTO stu = StudentDTO.builder()
                .name("mindu")
                .age(10)
                .addr("bucheon")
                .stuId("1324")
                .build();
                
        setAry(tea);
        setAry(stu);
        
        printAry();
    }

    public static void setAry(PersonDTO element) {
        perAry[idx++] = element;
    }
    
    public static void printAry() {
        System.out.println("전체 출력");
        System.out.println();
        for(PersonDTO element : perAry) {
            if (element == null) break;
            
            System.out.println(element.perInfo());
        }
    }
}
