package chapter1._livecode;

public class Live {
    public static void main(String[] args) {
        a();
        b();
    }

    public static void a() {
        System.out.println("A method called");
    }
    public static void b() {
        System.out.println("B method called");
    }
}


// package 전체를 컴파일
// JVM : Java virtual machine
// javac : java compiler

// main()실행 -> a()실행 -> a()종료 -> b()실행 -> b()종료 -> main()종료

// 디버깅 : break point 설정 -> 디버깅 -> 스텝인투 (프로그램 구조 확인)

// 타입 : 리터럴