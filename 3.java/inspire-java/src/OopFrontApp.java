import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.service.OopService;
import lgcns.inspire.inheritance.service.OopServiceImpl;
import lgcns.inspire.inheritance.util.Division;

public class OopFrontApp {
    public static void main(String[] args) {
        OopService svc = new OopServiceImpl();
        
        svc.setMakePerson(Division.STU, "hyunjin", 10, "seoul", "2025");
        svc.setMakePerson(Division.TEA, "supsup", 20, "incheon", "java");
        
        
        PersonDTO[] result = svc.getPersonList();
        for (PersonDTO person : result) {
            if (person == null) break;
            
            System.out.println(person.perInfo());
        }
        
        PersonDTO target = svc.getFindPerson("hyunjin1");
        if (target == null) {
            System.out.println("실패");
        }
        else {
            System.out.println(target.perInfo());
        }
    }
}
