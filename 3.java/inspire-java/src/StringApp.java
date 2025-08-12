public class StringApp {
        public static void main(String[] args) {
            // String str01 = "inspire";
            // String str02 = "inspire";
            String str01 = new String("inspire");
            String str02 = new String("inspire");
            
            if(str01 == str02) {
                System.out.println("same");
            }
            else {
                System.out.println("different");
            }
            if(str01.equals(str02)) {
                System.out.println("same");
            }
            else {
                System.out.println("different");
            }
        }
}
