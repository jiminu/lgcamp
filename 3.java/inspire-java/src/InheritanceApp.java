import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.sub.StudentDTO;
import lgcns.inspire.inheritance.sub.TeacherDTO;

public class InheritanceApp {
    
    public static void main(String[] args) {
        
        // PersonDTO tea = PersonDTO.builder()
        //                          .name("immsupp")
        //                          .age(20)
        //                          .addr("seoul")
        //                          .subject("java")
        //                          .build();
        // PersonDTO stu = PersonDTO.builder()
        //                          .name("minwoo")
        //                          .age(10)
        //                          .addr("bucheon")
        //                          .stuId("1324")
        //                          .build();
                                 
                                 
        // System.out.println(tea);
        // System.out.println(stu);
        
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
                                   
        // TeacherDTO[] teaAry = new TeacherDTO[10];
        // teaAry[0] = tea;
        // StudentDTO[] stuAry = new StudentDTO[10];
        // stuAry[0] = stu;
        
        PersonDTO[] perAry = new PersonDTO[10];
        
        perAry[0] = tea;
        perAry[1] = stu;
        
        System.out.println(perAry[0].getName());
        
        for (int i = 0; i < perAry.length; ++i) {
            PersonDTO per = perAry[i];
            
            if ( per == null ) {
                break;
            } else {
                System.out.println(per.perInfo());
            }
            
            
            // if ( per == null ) {
            //     break;
            // }
            // else if (per instanceof StudentDTO) {
            //     System.out.println(((StudentDTO)per).perInfo());
            // }
            // else if (per instanceof TeacherDTO) {
            //     System.out.println(((TeacherDTO)per).perInfo());
            // }
        }
    }    
}
