package lgcns.inspire.inheritance.service;

import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.sub.StudentDTO;
import lgcns.inspire.inheritance.sub.TeacherDTO;
import lgcns.inspire.inheritance.util.Division;

public class OopServiceImpl implements OopService{
    private PersonDTO[] persons;
    private int idx;

    public OopServiceImpl() {
        persons = new PersonDTO[10];
    }

    @Override
    public PersonDTO getFindPerson(String name) {
        
        for (PersonDTO person : persons) {
            if (person == null) break;
            if (person.getName().equals(name)) return person;
        }
        return null;
    }

    @Override
    public PersonDTO[] getPersonList() {
        return persons;
    }

    @Override
    public void setMakePerson(Division division, String name, int age, String address, String comm) {
        switch (division.getDivision()) {
            case "학생":
                StudentDTO stu = StudentDTO.builder()
                                           .name(name)
                                           .age(age)
                                           .addr(address)
                                           .stuId(comm)
                                           .build();
                setPerson(stu);
                break;
            case "강사":
                TeacherDTO tea = TeacherDTO.builder()
                                           .name(name)
                                           .age(age)
                                           .addr(address)
                                           .subject(comm)
                                           .build();
                setPerson(tea);
                break;
        
            default:
                break;
        }
        
    }

    private void setPerson(PersonDTO person) {
        persons[idx++] = person;
        
    }
    
}
