package chapter4.labs.lab3;

/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * final 키워드 예제 클래스
 */
public class FinalExample {
    // TODO: final 변수를 선언하고 초기화하세요.

    public static final double PI = 3.14159265359;

    // TODO: final 변수를 선언만 하고, 생성자에서 초기화하세요.

    private final String name;
    private final StringBuilder builder;


    // TODO: 생성자를 정의하세요.
    public FinalExample(String name) {
        // final 변수 초기화
        this.name = name;
        this.builder = new StringBuilder("Hello");
    }
    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("StringBuilder 내용: " + builder);
    }

    
    // TODO: final 메소드를 정의하세요.

    public final void finalMethod() {
        System.out.println("이 메소드는 오버라이딩할 수 없습니다.");
    }

    // TODO: final 매개변수를 받는 메소드를 정의하세요.

    public void normalMethod() {
        // 메소드 내부의 final 지역 변수
        final int count = 10;
        // count = 20; // 에러: final 변수는 값 변경 불가

        System.out.println("일반 메소드입니다. count = " + count);
    }
    
    public static void main(String[] args) {
        System.out.println("Final 키워드 예제를 실행합니다.");
        
        // TODO: FinalExample 객체를 생성하세요.
        FinalExample finalExample = new FinalExample("John");


        // TODO: 객체의 메소드를 호출하세요.

        finalExample.printInfo();
        
        // TODO: final 클래스의 객체를 생성하고 메소드를 호출하세요.

        FinalClass finalClass = new FinalClass();
        finalClass.display();


        // TODO: final 지역 변수를 선언하고 사용하세요.

        final int count = 10;
        System.out.println("count = " + count);
        
    }
}

// TODO: final 클래스를 정의하세요.

final class FinalClass {
    public void display() {
        System.out.println("이 클래스는 상속할 수 없습니다.");
    }
}
// TODO: 일반 클래스와 하위 클래스를 정의하고, final 메소드 오버라이딩을 시도해보세요.
// 일반 클래스
class Parent {
    // final 메소드
    public final void cannotOverride() {
        System.out.println("이 메소드는 오버라이딩할 수 없습니다.");
    }

    // 일반 메소드
    public void canOverride() {
        System.out.println("Parent: 이 메소드는 오버라이딩 가능합니다.");
    }
}
// 상속 예제
class Child extends Parent {
    // final 메소드 오버라이딩 시도
    // @Override
    // public void cannotOverride() { } // 에러: final 메소드는 오버라이딩 불가

    // 일반 메소드 오버라이딩
    @Override
    public void canOverride() {
        System.out.println("Child: 메소드를 오버라이딩했습니다.");
    }
}