package chapter4.labs.lab2;

/**
 * Lab 2: 생성자 활용하기
 * 
 * Book 클래스 정의하기
 */
public class Book {
    // TODO: 제목, 저자, 가격, 출판연도를 저장할 수 있는 필드를 정의하세요.
    // 필드
    String title;       // 제목
    String author;      // 저자
    int price;          // 가격
    int publishYear;    // 출판연도
    
    
    // TODO: 기본 생성자를 정의하세요.
    public Book() {
        System.out.println("Book 객체가 생성되었습니다. (기본 생성자)");
        this.title = "제목 없음";
        this.author = "저자 미상";
        this.price = 0;
        this.publishYear = 2023;
    }
    
    
    // TODO: 제목만 인자로 받는 생성자를 정의하세요. (this() 사용)

    public Book(String title) {
        this(title, "저자 미상", 0, 2023);
    }


    // TODO: 제목과 저자를 인자로 받는 생성자를 정의하세요. (this() 사용)

    public Book(String title, String author) {
        this(title, author, 0, 2023);
    }


    // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 정의하세요. (this() 사용)

    public Book(String title, String author, int price) {
        this(title, author, price, 2023);
    }



    // TODO: 모든 필드를 인자로 받는 생성자를 정의하세요.

    public Book(String title, String author, int price, int publishYear) {
        System.out.println("Book 객체가 생성되었습니다. (매개변수 4개 생성자)");
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishYear = publishYear;
    }
    
    // TODO: 책의 정보를 출력하는 메소드를 정의하세요.

    // 책 정보 출력 메소드
    public void displayInfo() {
        System.out.println("===== 책 정보 =====");
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        System.out.println("가격: " + price + "원");
        System.out.println("출판연도: " + publishYear + "년");
        System.out.println("==================");
    }
    
    
} 