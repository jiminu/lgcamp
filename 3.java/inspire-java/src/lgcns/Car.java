package lgcns;

public class Car {
    private String model, maker;
    private int price;
    
    

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car(String model, 
               String maker, 
               int price) {
        this.model = model;
        this.maker = maker;
        this.price = price;
    }
    
    public String dreamCarInfo() {
        return "your dream car is " + this.model + " from " + this.maker + ", price is " + this.price;
    }

    public void drive() {
        System.out.println("no parameters, no output");
    }
    
    public String repair() {
        System.out.println("no parameters, string output");

        return "repair done.";
    }
    
    public void performance(String fuel) {
        System.out.println("string parameter, no output");        
    }
    
    public String speed(int speed) {
        System.out.println("int parameter, string output");
        
        return "burung~";
    }
}
