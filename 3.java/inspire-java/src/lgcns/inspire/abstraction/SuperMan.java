package lgcns.inspire.abstraction;

import lgcns.inspire.abstraction.inter.Flyer;

public class SuperMan extends Animal implements Flyer{

    @Override
    public void fly() {
        System.out.println("슈퍼맨이 망토를 펄럭펄럭");
        
    }

    @Override
    public void landing() {
        System.out.println("슈퍼맨의 히어로 랜딩");
        
    }

    @Override
    public void takeOff() {
        System.out.println("슈퍼맨의 도약");        
    }
    
    

}
