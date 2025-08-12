package lgcns.inspire.factory;

import lgcns.inspire.abstraction.LgTV;
import lgcns.inspire.abstraction.SamsungTV;
import lgcns.inspire.abstraction.inter.TV;

public class BeanFactory {
    private static BeanFactory instance;
    private TV[] ary;
    private BeanFactory() {
        ary = new TV[2];
        ary[0] = new SamsungTV();
        ary[1] = new LgTV();
    }
    
    public static BeanFactory getInstance() {
        if (instance == null) {
            instance = new BeanFactory();
        }
        
        return instance;
    }
    
    public TV getBrand(String brand) {
        return (brand.equals("samsung")) ? ary[0] : ary[1];
    }
}
