package chapter9.labs.lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 람다식 활용 실습
 *
 * 이 실습에서는 다양한 람다식 표현과 함수형 인터페이스를 사용하는 방법을 연습합니다.
 */
public class LambdaLab {

    public static void main(String[] args) {
        // TODO: 아래 작업을 완성하세요.
        
        // 1. 함수형 인터페이스 활용
        System.out.println("===== 함수형 인터페이스 활용 =====");
        
        // TODO: Predicate<Integer> 타입의 람다식을 작성하여 짝수인지 검사하는 기능을 구현하세요.
        // 힌트: (num -> num % 2 == 0) 형태로 작성
        Predicate<Integer> isEven = num -> num%2 == 0;
        System.out.println("짝수인지 검사 " + isEven.test(2));

        // TODO: Function<String, Integer> 타입의 람다식을 작성하여 문자열의 길이를 반환하는 기능을 구현하세요.
        // 힌트: String::length 메소드 참조 사용

        Function<String, Integer> stringLength = String::length;
        System.out.println("문자열의 길이 반환: " + stringLength.apply("hello world"));
        // TODO: Consumer<String> 타입의 람다식을 작성하여 문자열을 출력하는 기능을 구현하세요.
        // 힌트: System.out::println 메소드 참조 사용

        Consumer<String> printString = System.out::println;
        System.out.println("문자열을 출력: "+ printString);
        printString.accept("hello world");
        // TODO: Supplier<Double> 타입의 람다식을 작성하여 0.0~1.0 사이의 난수를 반환하는 기능을 구현하세요.
        // 힌트: Math::random 메소드 참조 사용
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("0.0~1.0 사이의 난수를 반환 " + randomSupplier.get());
        
        // 2. 리스트 정렬에 Comparator 활용
        System.out.println("\n===== 리스트 정렬 Comparator 활용 =====");
        
        List<String> names = new ArrayList<>(Arrays.asList(
            "윤학생", "김학생", "이학생", "박학생", "손학생", "서학생"
        ));
        
        // TODO: 이름 길이 순으로 정렬하는 Comparator를 람다식으로 작성하세요.
        // 힌트: names.sort((s1, s2) -> ...)
        names.sort(Comparator.comparing(String::length));
        System.out.println("이름 길이 순으로 정렬: " + names);

        // TODO: 이름 길이가 같으면 사전순으로 정렬하는 Comparator를 작성하세요. (복합 조건)
        // 힌트: Comparator.comparing(String::length).thenComparing(...)

        names.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
        System.out.println("이름 길이가 같으면 사전순으로 정렬: " + names);
        
        // 3. 필터링 활용
        System.out.println("\n===== 필터링 활용 =====");
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
        // TODO: 짝수만 필터링하여 새 리스트에 저장하세요.
        // 힌트: numbers.stream()...collect
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("짝수만 필터링: " + evens);

        // TODO: 3의 배수만 필터링하여 새 리스트에 저장하세요.
        List<Integer> multiplesOfThree = numbers.stream()
                .filter(n -> n % 3 == 0)
                .collect(Collectors.toList());
        System.out.println("3의 배수만 필터링: " + multiplesOfThree);


        // 4. forEach와 Consumer 활용
        System.out.println("\n===== forEach와 Consumer 활용 =====");
        
        // TODO: 메소드 참조를 사용하여 names 리스트의 각 이름을 출력하세요.
        // names.forEach(...);
        names.forEach(System.out::println);

        // TODO: 람다식을 사용하여 numbers 리스트의 각 숫자를 제곱하여 출력하세요.
        // numbers.forEach(...);
        numbers.forEach(n -> System.out.println(n + " 제곱: " + (n * n)));


        // 5. 메소드 참조 활용
        System.out.println("\n===== 메소드 참조 활용 =====");
        
        // TODO: 정적 메소드 참조를 사용하여 문자열을 정수로 변환하는 Function을 구현하세요.
        // Function<String, Integer> parseIntFunc = ...;
        Function<String, Integer> parseIntFunc = Integer::parseInt;
        System.out.println("\"1234\" 를 정수로 변환: " + parseIntFunc.apply("1234"));
        // TODO: 인스턴스 메소드 참조를 사용하여 문자열을 대문자로 변환하는 Function을 구현하세요.
        // Function<String, String> toUpperFunc = ...;
        Function<String, String> toUpperFunc = String::toUpperCase;
        System.out.println("\"hello\" 를 대문자로 변환: " + toUpperFunc.apply("hello"));
        
        // 6. 사용자 정의 함수형 인터페이스 활용
        System.out.println("\n===== 사용자 정의 함수형 인터페이스 활용 =====");
        
        // TODO: Calculator 인터페이스의 구현체를 람다식으로 생성하여 add, subtract, multiply, divide 기능을 구현하세요.
        // Calculator add = ...;
        // Calculator subtract = ...;
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> a / b;

    }
    
    // 6번 문제를 위한 함수형 인터페이스
    @FunctionalInterface
    interface Calculator {
        double calculate(double a, double b);
        
        // 디폴트 메소드로 연산 결과 포맷팅 기능 추가
        default String calculateAndFormat(double a, double b) {
            return String.format("결과: %.2f", calculate(a, b));
        }
    }
} 