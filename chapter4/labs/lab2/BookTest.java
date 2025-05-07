package chapter4.labs.lab2;


/**
 * Lab 2: 생성자 활용하기
 * 
 * Book 클래스를 테스트하는 메인 클래스
 */
public class BookTest {
    public static void main(String[] args) {
        System.out.println("Book 클래스 테스트를 시작합니다.");
        
        // TODO: 기본 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        // 기본 생성자를 이용한 객체 생성
        Book book1 = new Book();
        book1.displayInfo();
        System.out.println();
        
        
        // TODO: 제목만 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.

        Book book2 = new Book("Java Programming");
        book2.displayInfo();
        System.out.println();
        
        // TODO: 제목과 저자를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.

        Book book3 = new Book("Database Basics", "Charles");
        book3.displayInfo();
        System.out.println();
        
        // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.

        Book book4 = new Book("Understanding Algorithms", "Sarah", 25000);
        book4.displayInfo();
        System.out.println();
        
        // TODO: 모든 필드를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.

        Book book5 = new Book("Cloud Computing", "Matthew", 30000, 2022);
        book5.displayInfo();
        System.out.println();
        
        // TODO: 객체를 생성한 후 필드 값을 변경하고 정보를 출력하세요.

        Book book6 = new Book("Initial Title", "Initial Author");
        book6.title = "Changed Title";
        book6.author = "Changed Author";
        book6.price = 15000;
        book6.publishYear = 2024;
        book6.displayInfo();
    }
} 