package chapter4.labs.lab1;

/**
 * Lab 1: 클래스와 객체 만들기
 * 
 * Person 클래스를 테스트하는 메인 클래스
 */
public class PersonTest {
    public static void main(String[] args) {
        System.out.println("Person 클래스 테스트를 시작합니다.");
        
        // TODO: 이름이 John, 나이가 20, 성별이 Male인 Person 객체를 생성하세요.

        Person person1 = new Person();

        // 객체의 필드 값 설정
        person1.name = "John";
        person1.age = 20;
        person1.gender = "Male";
        // TODO: 생성한 객체의 정보를 출력하세요.
        person1.introduce();

        System.out.println("--------------------");
        
        
        // TODO: 생일이 지나 나이가
        person1.addAge();
        person1.introduce();

        System.out.println("--------------------");

        // TODO: 이름이 Emily, 나이가 25, 성별이 Female인 두 번째 Person 객체를 생성하세요.
        Person person2 = new Person();

        // 객체의 필드 값 설정
        person2.name = "Emily";
        person2.age = 25;
        person2.gender = "Female";

        // TODO: 두 번째 객체의 정보를 출력하세요.
        person2.introduce();

        System.out.println("--------------------");
        
        // TODO: 두 번째 객체의 나이를 증가시키고 정보를 다시 출력하세요.
        person2.addAge();
        person2.introduce();

        System.out.println("--------------------");
        
        // TODO: 추가로 여러 Person 객체를 생성하여 배열로 관리하고 모든 객체의 정보를 출력하세요.

        // 배열을 이용한 여러 Person 객체 관리
        Person[] people = new Person[3];

        // 배열에 객체 할당
        people[0] = person1;
        people[1] = person2;

        // 배열에 새 객체 생성해서 할당
        people[2] = new Person();
        people[2].name = "Michael";
        people[2].age = 30;
        people[2].gender = "Male";

        // 배열을 순회하며 객체 사용
        System.out.println("사람 목록:");
        for (Person p : people) {
            p.introduce();
            System.out.println();
        }
    }
} 