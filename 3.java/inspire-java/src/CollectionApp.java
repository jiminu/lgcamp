import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.sub.StudentDTO;
import lgcns.inspire.inheritance.sub.TeacherDTO;

public class CollectionApp {
    
    public static void main(String[] args) {
        System.out.println(">>> array");
        int[] ary = new int[5];
        ary[0] = 1;
        ary[1] = 2;
        ary[2] = 3;
        ary[3] = 4;
        ary[4] = 5;
        
        System.out.println(">>> length : " + ary.length);
        
        System.out.println(">>> list");
        List<Integer> list = new ArrayList<Integer>();
        
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(1);

        System.out.println(list.toString());

        for (int i=0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
        
        List<PersonDTO> personList = new ArrayList<PersonDTO>();
        
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
        personList.add(tea);
        personList.add(stu);
        
        for(int i=0; i < personList.size(); ++i) {
            System.out.println(personList.get(i).perInfo());
        }
        
        Set<String> set = new HashSet<>();
        set.add("jslim");
        set.add("inspire");
        set.add("lgcns");
        set.add("lgcns");
        set.add("lgcns");
        System.out.println(set);
        
        Object[] setAry = set.toArray();
        
        for ( Object value : setAry) {
            System.out.println(value);
        }
        
        Map<String, List<? extends PersonDTO>> map = new HashMap<>();

        List<StudentDTO> studentList = new ArrayList<>();
        studentList.add(stu);
        
        List<TeacherDTO> teacherList = new ArrayList<>();
        teacherList.add(tea);
        
        map.put("stu", studentList);
        map.put("tea", teacherList);
        
        List<? extends PersonDTO> students = map.get("stu");
        for (PersonDTO person : students) {
            System.out.println(person.perInfo());
        }
        List<? extends PersonDTO> teachers = map.get("tea");
        for (PersonDTO person : teachers) {
            System.out.println(person.perInfo());
        }
        
    }
}
