package chapter5.labs.lab3;

import java.util.ArrayList;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * ShoppingCart 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현한 다양한 상품을 담는 장바구니 역할을 합니다.
 */
public class ShoppingCart {
    // TODO: 상품 목록을 저장할 리스트 선언

    private ArrayList<Buyable> items;

    ArrayList<Buyable> cart = new ArrayList<>();

    // TODO: 생성자 정의

    public ShoppingCart() {
        items = new ArrayList<>();
    }
    // TODO: 장바구니에 상품 추가하는 메소드 구현

    public void addItem(Buyable item) {
        items.add(item);
    }
    // TODO: 장바구니에서 상품 제거하는 메소드 구현

    public void removeItem(Buyable item) {
        items.remove(item);
    }
    // TODO: 장바구니의 총 금액을 계산하는 메소드 구현
    public double getTotalPrice() {
        double total = 0;
        for (Buyable item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    // TODO: 장바구니 상품 목록을 출력하는 메소드 구현
    public void printCartItems() {
        System.out.println("장바구니 상품 목록:");
        for (Buyable item : items) {
            item.printInfo();
        }
    }
} 