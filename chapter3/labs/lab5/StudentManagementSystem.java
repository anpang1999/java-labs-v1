package chapter3.labs.lab5;

import java.util.Scanner;

/**
 * 학생 성적 관리 프로그램 (종합 프로젝트)
 */
public class StudentManagementSystem {
    // TODO: 학생 성적 등급을 나타내는 Grade Enum을 정의하세요.
    // A(90-100), B(80-89), C(70-79), D(60-69), F(0-59) 등급이 있어야 합니다.

    // 최대 학생 수
    private static final int MAX_STUDENTS = 100;
    
    // 학생 정보 배열
    private static String[] names = new String[MAX_STUDENTS]; // 이름 배열
    private static int[] scores = new int[MAX_STUDENTS]; // 성적 배열
    private static int studentCount = 0; // 현재 저장된 학생 수
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("===== 학생 성적 관리 프로그램 =====");
        
        while (running) {
            printMenu();
            int choice = getMenuChoice(scanner);
            
            switch (choice) {
                case 1:
                    // TODO: 성적 입력 기능을 구현하세요.
                    // 학생 이름과 성적을 입력받아 배열에 저장합니다.

                    System.out.print("학생 이름을 입력하세요: ");
                    String name = scanner.nextLine();

                    System.out.print("성적을 입력하세요: ");
                    int score = Integer.parseInt(scanner.nextLine());

                    names[studentCount] = name;
                    scores[studentCount] = score;
                    studentCount++;

                    System.out.println("학생 정보가 저장되었습니다.");
                    break;

                case 2:
                    // TODO: 성적 수정 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적을 수정합니다.
                    System.out.print("성적을 수정할 학생 이름을 입력하세요: ");
                    String targetName = scanner.nextLine();

                    int index = findStudentIndexByName(targetName);
                    if (index != -1) {
                        System.out.print("새로운 성적을 입력하세요: ");
                        int newScore = Integer.parseInt(scanner.nextLine());
                        scores[index] = newScore;
                        System.out.println("성적이 수정되었습니다.");
                    } else {
                        System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
                    }

                    break;
                case 3:
                    // TODO: 성적 조회 기능을 구현하세요.
                    // 모든 학생의 이름, 성적, 등급을 출력합니다.
                    // 전체 성적의 합계, 평균, 최고 성적, 최저 성적도 출력합니다.
                    int sum = calculateTotalScore();

                    int max = getMaxScore();
                    int min = getMinScore();

                    System.out.println("===== 성적 조회 =====");
                    for (int i = 0; i < studentCount; i++) {
                        sum += scores[i];
                        if (scores[i] > max) max = scores[i];
                        if (scores[i] < min) min = scores[i];

                        Grade grade = Grade.getGradeFromScore(scores[i]);
                        System.out.println((i + 1) + ". " + names[i] + " - 성적: " + scores[i] + "점, 등급: " + grade);
                    }

                    double average = calculateAverageScore();

                    System.out.println("\n총합: " + sum + "점");
                    System.out.println("평균: " + String.format("%.2f", average) + "점");
                    System.out.println("최고 성적: " + max + "점");
                    System.out.println("최저 성적: " + min + "점");
                    
                    break;
                case 4:
                    // TODO: 검색 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적과 등급을 조회합니다.
                    System.out.print("검색할 학생 이름을 입력하세요: ");
                    String searchName = scanner.nextLine();

                    for (int i = 0; i < studentCount; i++) {
                        if (names[i].equals(searchName)) {
                            int targetScore = scores[i]; // 이름을 score 대신 targetScore로 변경
                            Grade grade = Grade.getGradeFromScore(targetScore);
                            System.out.println(names[i] + " - 성적: " + targetScore + "점, 등급: " + grade);
                            break;
                        }
                    }
                    break;
                case 5:
                    // TODO: 통계 기능을 구현하세요.
                    // 등급별 학생 수와 비율을 출력합니다.
                    // 등급별 카운트 배열
                    int[] gradeCounts = new int[Grade.values().length];

                    // 등급별 학생 수 집계
                    for (int i = 0; i < studentCount; i++) {
                        Grade grade = Grade.getGradeFromScore(scores[i]);
                        gradeCounts[grade.ordinal()]++; // ordinal()은 enum의 순서값
                    }

                    System.out.println("===== 등급별 통계 =====");
                    for (Grade grade : Grade.values()) {
                        int count = gradeCounts[grade.ordinal()];
                        double ratio = (double) count / studentCount * 100;
                        System.out.printf("%s: %d명 (%.2f%%)%n", grade.name(), count, ratio);
                    }
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // 메뉴 출력 메소드
    private static void printMenu() {
        System.out.println("\n===== 메뉴 =====");
        System.out.println("1. 성적 입력");
        System.out.println("2. 성적 수정");
        System.out.println("3. 성적 조회");
        System.out.println("4. 학생 검색");
        System.out.println("5. 통계 보기");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
    
    // 메뉴 선택 입력 메소드
    private static int getMenuChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1; // 잘못된 입력
        } finally {
            scanner.nextLine(); // 버퍼 비우기
        }
    }
    
    // TODO: 성적으로부터 등급을 계산하는 메소드를 구현하세요.
    // 입력받은 성적에 따라 Grade Enum 상수를 반환합니다.

    
    // TODO: 전체 성적의 합계를 계산하는 메소드를 구현하세요.
    // 전체 성적의 합계를 계산하는 메소드
    private static int calculateTotalScore() {
        int sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += scores[i];
        }
        return sum;
    }


    // TODO: 전체 성적의 평균을 계산하는 메소드를 구현하세요.
    private static double calculateAverageScore() {
        if (studentCount == 0) return 0.0;
        return (double) calculateTotalScore() / studentCount;
    }
    
    // TODO: 최고 성적을 찾는 메소드를 구현하세요.

    private static int getMaxScore() {
        if (studentCount == 0) return 0;
        int max = scores[0];
        for (int i = 1; i < studentCount; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    // TODO: 최저 성적을 찾는 메소드를 구현하세요.

    private static int getMinScore() {
        if (studentCount == 0) return 0;
        int min = scores[0];
        for (int i = 1; i < studentCount; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }


    // TODO: 학생 이름으로 배열에서 위치(인덱스)를 찾는 메소드를 구현하세요.

    private static int findStudentIndexByName(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        return -1; // 이름이 없을 경우 -1 반환
    }

} 