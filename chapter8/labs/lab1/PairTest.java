package chapter8.labs.lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Lab 1: 제네릭 클래스 구현 테스트
 *
 * Pair 클래스와 PairUtils 클래스의 기능을 테스트합니다.
 */
public class PairTest {
    public static void main(String[] args) {
        System.out.println("=== Pair 클래스 테스트 ===");
        
        // TODO: Pair 클래스의 다양한 타입 매개변수를 사용하여 객체를 생성하고 테스트하세요.
        // Integer와 String 타입의 Pair
        Pair<Integer, String> p1 = new Pair<>(1, "one");


        // Double과 Double 타입의 Pair
        Pair<Double, Double> p2 = new Pair<>(3.14, 2.71);

        // 사용자 정의 클래스를 사용한 Pair
        Pair<String, String> p3 = new Pair<>("hello", "world");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);


        System.out.println("\n=== PairUtils 클래스 테스트 ===");
        
        // TODO: PairUtils 클래스의 메소드를 테스트하세요.
        // of 메소드 테스트
        Pair<String, Integer> pair1 = PairUtils.of("apple", 10);
        // swap 메소드 테스트
        Pair<Integer, String> swapped = PairUtils.swap(pair1);
        System.out.println("Swapped: " + swapped);

        // 숫자 타입의 sum 메소드 테스트
        Pair<Integer, Integer> numberPair = new Pair<>(5, 7);
        System.out.println("Sum: " + PairUtils.sum(numberPair));

        // 타입 제한 테스트 (Number 하위 클래스만 가능)



        // 와일드카드 메소드 테스트
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        PairUtils.printList(stringList);

        List<Integer> integerList = new ArrayList<>();
        PairUtils.addIntegers(integerList, 5);
        PairUtils.printList(integerList);
        System.out.println("Sum of list: " + PairUtils.sumOfList(integerList));

    }
}