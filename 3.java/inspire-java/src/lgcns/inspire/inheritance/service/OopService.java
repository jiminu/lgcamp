package lgcns.inspire.inheritance.service;

import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.util.Division;

public interface OopService {
    public void setMakePerson(Division division, String name, int age, String address, String comm);
    public PersonDTO getFindPerson(String name);
    public PersonDTO[] getPersonList();

    // public void setPerson(PersonDTO person);
}
