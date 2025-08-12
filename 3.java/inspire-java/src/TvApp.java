import lgcns.inspire.abstraction.LgTV;
import lgcns.inspire.abstraction.SamsungTV;
import lgcns.inspire.abstraction.inter.TV;
import lgcns.inspire.factory.BeanFactory;

public class TvApp {
    
    public static void main(String[] args) {
        // TV tv = new LgTV();
        // tv.powerOn();
        
        BeanFactory bean1 = BeanFactory.getInstance();
        BeanFactory bean2 = BeanFactory.getInstance();

        System.out.println(bean1);
        System.out.println(bean2);
    }
}
