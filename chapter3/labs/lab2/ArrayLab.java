package chapter3.labs.lab2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열 활용하기 실습
 */
public class ArrayLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 정수형 배열 활용
        System.out.println("===== 정수형 배열 활용 =====");

        // TODO: 5개의 정수를 입력받아 배열에 저장하고, 합계와 평균을 계산하여 출력하세요.
        // 힌트: Scanner를 이용하여 사용자로부터 입력을 받으세요.
        System.out.println("5개의 정수를 입력: ");
        int[] numbers1 = new int[5];

        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = scanner.nextInt();
        }

        int numbers1_sum = numbers1[0] + numbers1[1] + numbers1[2] + numbers1[3] + numbers1[4];
        int numbers1_avg = numbers1_sum / 5;

        System.out.println("numbers1: " + Arrays.toString(numbers1));
        System.out.println("합계: " + numbers1_sum);
        System.out.println("평균: " + numbers1_avg);


        // 2. 문자열 배열 활용
        System.out.println("\n===== 문자열 배열 활용 =====");

        // TODO: 5개의 이름을 입력받아 배열에 저장하고, 특정 문자(예: 'A')로 시작하는 이름을 검색하여 출력하세요.
        // 힌트: String 클래스의 startsWith() 또는 charAt() 메소드를 활용하세요.
        System.out.println("5개의 이름을 입력: ");
        String[] names = new String[5];
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.next();
        }
        System.out.println("names: " + Arrays.toString(names));

        for (int i = 0; i < names.length; i++) {
            if (names[i].startsWith("A")) {
                System.out.println("A로 시작하는 이름 검색: " + names[i]);
            }
        }

        // 3. 배열 정렬
        System.out.println("\n===== 배열 정렬 =====");

        // TODO: 사용자로부터 5개의 정수를 입력받아 배열에 저장한 후, 오름차순으로 정렬하여 출력하세요.
        // 힌트: 이중 반복문을 사용하여 버블 정렬 알고리즘을 구현하거나, Arrays.sort()를 활용하세요.
        System.out.println("5개의 정수를 입력: ");
        int[] numbers2 = new int[5];

        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = scanner.nextInt();
        }
        Arrays.sort(numbers2);
        System.out.println("numbers2: " + Arrays.toString(numbers2));

        // 4. 2차원 배열을 이용한 행렬 덧셈
        System.out.println("\n===== 2차원 배열을 이용한 행렬 덧셈 =====");

        // TODO: 두 개의 2x3 행렬을 입력받아 행렬 덧셈을 수행하고 결과를 출력하세요.
        // 힌트: 중첩 반복문을 사용하세요.

        int[][] matrix1 = new int[2][3];
        int[][] matrix2 = new int[2][3];
        int[][] sum = new int[2][3];

        // 첫 번째 행렬 입력
        System.out.println("첫 번째 2x3 행렬을 입력:");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // 두 번째 행렬 입력
        System.out.println("두 번째 2x3 행렬을 입력:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // 행렬 덧셈 수행
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("행렬 덧셈: ");
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println(); // 줄바꿈
        }



        // 5. 배열을 이용한 간단한 데이터 분석
            System.out.println("\n===== 배열을 이용한 데이터 분석 =====");

            // TODO: 10개의 정수를 입력받아 배열에 저장한 후, 최댓값, 최솟값, 중앙값(또는 평균)을 계산하여 출력하세요.
            // 힌트: 정렬을 활용하면 중앙값을 쉽게 찾을 수 있습니다.
            System.out.println("10개의 정수를 입력: ");
            int[] numbers3 = new int[10];

            for (int i = 0; i < numbers1.length; i++) {
                numbers3[i] = scanner.nextInt();
            }

            Arrays.sort(numbers3);

            int min = numbers3[0];
            int max = numbers3[numbers3.length - 1];

            int numbers3_sum = 0;
            for (int num : numbers3) {
                numbers3_sum += num;
            }
            int avg = numbers3_sum / numbers3.length;

            System.out.println("최댓값: " + max);
            System.out.println("최솟값: " + min);
            System.out.println("중앙값: " + avg);

            scanner.close();
        }
    }
