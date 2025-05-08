package chapter5.labs.lab2;

/**
 * Lab 2: 추상 클래스 활용하기
 * 
 * 여러 동물 객체를 생성하고, 각 동물의 정보와 소리를 출력하는 테스트 클래스입니다.
 */
public class AnimalTest {
    public static void main(String[] args) {
        System.out.println("Lab 2: 추상 클래스 활용하기 실습");
        
        // TODO: Dog 객체 생성

        Dog dog = new Dog("바둑이", 3, "시베리안 허스키");
        // TODO: Cat 객체 생성

        Cat cat = new Cat("나비", 2, "회색");
        // TODO: Bird 객체 생성

        Bird bird = new Bird("짹짹이", 1, 15.5,"참새");

        Animal animal2 = new Bird("뚤기", 1, 15.5,"비둘기");

        // TODO: 각 동물의 정보와 소리 출력

        dog.printInfo();
        dog.sound();

        cat.printInfo();
        cat.sound();

        bird.printInfo();
        bird.sound();


        // TODO: 배열을 사용하여 여러 Animal 객체 관리하기

        Animal[] animals = { dog, cat, bird };


        // TODO: 모든 동물에 대해 반복하여 정보와 소리 출력하기

        for (Animal animal : animals) {
            animal.printInfo();
            animal.sound();
            System.out.println();
        }

        dog.bark();
        cat.meow();
        bird.fly();

        ((Bird) animal2).fly(); //형변환

    }
} 