package lgcns.inspire.inheritance;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
public class PersonDTO {
    // common factor
    private String name;
    private int age;
    private String addr;
    
    public String perInfo() {
        return "PersonDTO name=" + name + ", age=" + age + ", addr=" + addr;
    }
    
    
}
