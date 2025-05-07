package chapter4.labs.lab3;


/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * Calculator 클래스를 테스트하는 메인 클래스
 */
public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("Calculator 클래스 테스트를 시작합니다.");
        
        // TODO: 클래스 이름으로 static 상수에 접근하여 출력하세요.
        System.out.println("PI 값: " + Calculator.PI);


        // TODO: 객체 생성 없이 static 메소드를 호출하여 원의 면적과 둘레를 계산하세요.
        System.out.println("원의 넓이(반지름 5): " + Calculator.calculateCircleArea(5));
        System.out.println("원의 둘레(반지름 5): " + Calculator.calculateCircleCircumference(5));


        // TODO: 객체 생성 없이 static 메소드를 호출하여 사각형의 면적을 계산하세요.
        
        
        // TODO: Calculator 객체를 생성하고 인스턴스 메소드를 호출하세요.
        System.out.println("\n--- 계산기 객체 생성 ---");
        Calculator calc1 = new Calculator("Model1");

        calc1.calculate();
        
        // TODO: 생성된 Calculator 객체의 정보를 출력하세요.

        calc1.calculatorInfo();

        // TODO: 추가로 Calculator 객체를 생성하고, 객체 생성 횟수를 확인하세요.
        System.out.println("\n--- 계산기 객체 추가 생성 ---");

        Calculator calc2 = new Calculator("Model2");

        Calculator.staticMethodExample();


        // TODO: 각 객체의 인스턴스 변수 값과 static 변수 값을 비교하세요.

        System.out.println("\n--- 인스턴스 변수 vs static 변수 ---");
        calc1.calculate();
        calc2.calculate();
        calc1.calculatorInfo();
        calc2.calculatorInfo();

        // static 변수: 모든 객체가 공유
        System.out.println("\n현재 생성된 계산기 수: " + chapter4.examples.ex3.Calculator.getCalculatorCount());

    }
} 