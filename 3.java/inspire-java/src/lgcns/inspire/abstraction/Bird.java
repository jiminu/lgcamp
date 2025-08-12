package lgcns.inspire.abstraction;

import lgcns.inspire.abstraction.inter.Flyer;

public class Bird extends Animal implements Flyer{

    @Override
    public void fly() {
        System.out.println("새가 퍼덕퍼덕");
        
    }

    @Override
    public void landing() {
        System.out.println("새가 땅에 앉기");
    }

    @Override
    public void takeOff() {
        System.out.println("새가 날아오르라 주작이여");
    }
    
    
    
}
