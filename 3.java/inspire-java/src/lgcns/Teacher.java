package lgcns;

public class Teacher {
    public String name;
    public String mbti;
    public String birthPlace;
    public double height;
    public int age;
    public boolean isMarriage;

    public Teacher() {
        
    }

    public Teacher(String name, 
                   String mbti, 
                   String birthPlace, 
                   double height, 
                   int age, 
                   boolean isMarriage) {
        this.name       = name;
        this.mbti       = mbti;
        this.birthPlace = birthPlace;
        this.height     = height;
        this.age        = age;
        this.isMarriage = isMarriage;
    }


}
