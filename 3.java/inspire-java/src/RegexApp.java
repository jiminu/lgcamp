import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexApp {
    public static void main(String[] args) {

        /*
         * 정규표현식
         * - 패턴을 정의하고 그 패턴에 맞는 문자열을 추출하거나 치환
         * - java.util.regex(Pattern, Matcher)
         */

        String txt = "저는 남자이고 제 인스타그램 아이디는 holyshit이고 이메일은 whoasn@naver.com이고 폰은 010-1234-9876입니다";

        Pattern pattern = Pattern.compile("01[016789]-\\d{3,4}-\\d{4}");

        Matcher match = pattern.matcher(txt);
        if(match.find()) {
            System.out.print("전화번호 : ");
            System.out.println(match.group());
        }
        
        pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
        match = pattern.matcher(txt);
        if(match.find()) {
            System.out.print("이메일 : ");
            System.out.println(match.group());
        }
        
        
    }
}
