package lgcns.inspire.inheritance.util;

public enum Division {
    STU("학생"), TEA("강사");
    
    
    private final String division;
    private Division(String division) {
        this.division = division;
    }   
    
    public String getDivision() {
        return this.division;
    }
    
}