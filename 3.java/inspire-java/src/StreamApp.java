
/*
    Collection - Java Stream ( 코드의 가독성, 병렬처리 )
    Stream API
    - 원본데이터 소스 변경 X
    - 일회용 (한 번 사용하면 재사용 X)
    - 병렬처리(thread) 로 실행속도 빠름.
    - 작업을 내부 반복으로 처리(람다식)
    
    함수형 인터페이스
    - 가질 수 있는 추상 메서드는 딱 하나

    Supplier : 매개변수 X, 반환값만 가지는 인터페이스
    Function : 매개변수 O, 반환값도 가지는 인터페이스
    Consumer : 매개변수 O, 반환값이 없는 인터페이스
    Predicate: 매개변수 O, Boolean 반환
    
    람다식은 하나의 메서드를 식으로 표현
    - 메서드의 이름이 없다.
    - 익명 형태를 가짐.
    
 */

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import lgcns.inspire.function.InspireFunction;
import lgcns.inspire.post.domain.dto.PostResponseDTO;

public class StreamApp {
    
    public static void main(String[] args) {
        InspireFunction lambdaFunc = (x, y) -> x >= y ? x : y;
        System.out.println(lambdaFunc.max(100, 200));
        
        System.out.println(">>> supplier    get");
        Supplier<String> supplier = () -> "holy moly";
        System.out.println(supplier.get());

        System.out.println(">>> consumer    accept");
        Consumer<String> consumer = (x) -> System.out.println(x.split(" ")[0]);
        consumer.andThen(System.out::println).accept("hello world");
        
        
        System.out.println();
        System.out.println(">>> Function    apply");
        Function<String, Integer> func = (str) -> str.length();
        int len = func.apply("inspiressss");
        System.out.println(len);
        
        
        
        System.out.println();
        System.out.println(">>> Predicate   test");
        Predicate<String> pred = (str) -> str.equals("lgcns");
        
        Boolean result = pred.test("lgc1ns");
        System.out.println(result);
        
        List<String> brands = Arrays.asList("samsung", "lg");
        brands.stream()
              .forEach(System.out::println);
              
        System.out.println(">>> optional");
        /*
        - 어떤 메서드가 null을 반환할지 확신할 수 없거나
          null 처리를 놓쳐서 발생하는 예외를 처리하기 위함
            주의
            - 메서드의 반환타입으로 사용 (전역변수나 매개변수로 사용 X)
            - 사용의도에 맞게 사용 (null을 넣으면 안됨)
         */
        
        Optional<String> op1 = Optional.of("jslim");
        System.out.println(op1.get());
        
        Optional<PostResponseDTO> op2 = Optional.empty();
        if (op2.isPresent()) {
            System.out.println(op2.get());
        }
    }
}
