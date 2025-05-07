package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * 인터페이스 구현과 다형성을 테스트하는 클래스입니다.
 */
public class ShopTest {
    public static void main(String[] args) {
        System.out.println("Lab 3: 인터페이스 활용하기 실습");
        
        // TODO: Book 객체 생성

        Book book = new Book("자바 프로그래밍", 15000, "류현진");

        // TODO: Electronics 객체 생성
        Electronics phone = new Electronics("아이폰 15", 1250000, "애플");


        // TODO: DiscountedBook 객체 생성
        DiscountedBook discountedBook = new DiscountedBook("자료구조", 20000, "문동주", 0.2);


        // TODO: ShoppingCart 객체 생성

        ShoppingCart cart = new ShoppingCart();

        // TODO: 장바구니에 상품 추가하기
        cart.addItem(book);
        cart.addItem(phone);
        cart.addItem(discountedBook);
        
        // TODO: 장바구니 내용과 총액 출력하기
        cart.printCartItems();
        System.out.println("총 금액: " + cart.getTotalPrice() + "원");
        
        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        //       - 모든 상품의 정보 출력하기

        System.out.println("\nBuyable 배열 다형성 테스트:");
        Buyable[] items = {book, phone, discountedBook};
        for (Buyable item : items) {
            item.printInfo();
        }
        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        System.out.println("\n할인 적용 상품 정보:");
        for (Buyable item : items) {
            if (item instanceof Discountable) {
                ((Discountable) item).printDiscountInfo();
            }
        }
    }
} 