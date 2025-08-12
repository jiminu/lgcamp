import lgcns.inspire.abstraction.Animal;
import lgcns.inspire.abstraction.Bird;
import lgcns.inspire.abstraction.SuperMan;
import lgcns.inspire.abstraction.inter.Flyer;

public class AbstractApp {
    public static void main(String[] args) {
        
        Flyer[] animals = new Flyer[2];
        animals[0] = new Bird();
        animals[1] = new SuperMan();
        
        for (Flyer animal : animals) {
            animal.fly();
        }
    }
    
}
