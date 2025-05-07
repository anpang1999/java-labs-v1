package chapter4.labs.lab1;

/**
 * Lab 1: 클래스와 객체 만들기
 * 
 * Person 클래스 정의하기
 */
public class Person {
    // TODO: 이름, 나이, 성별을 저장할 수 있는 필드를 정의하세요.
    String name;    // 이름
    int age;        // 나이
    String gender;  // 성별



    // TODO: 객체 정보를 출력하는 메소드를 작성하세요.
    // 자기소개 메소드
    public void introduce() {
        System.out.println("안녕하세요. 저는 " + name + "입니다.");
        System.out.println("나이는 " + age + "세이고, 성별은 " + gender + "입니다.");
    }

    
    // TODO: 생일이 지났을 때 나이를 한 살 증가시키는 메소드를 작성하세요.

    // 나이를 한 살 증가시키는 메소드
    public void addAge() {
        age++;
        System.out.println(name + "의 나이가 1살 증가했습니다. 현재 나이: " + age);
    }
} 