package chapter3.labs.lab4;


import java.util.Scanner;

/**
 * Enum(열거형) 활용하기 실습
 */
public class EnumLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 요일 Enum 활용하기
        System.out.println("===== 요일 Enum 활용하기 =====");
        System.out.println("요일을 입력하세요 (월, 화, 수, 목, 금, 토, 일): ");
        String input = scanner.nextLine();

        // TODO: 입력받은 요일에 해당하는 DayOfWeek Enum 상수를 찾아 switch 문에서 활용하세요.
        // 평일(월~금)인 경우 "평일입니다."를, 주말(토, 일)인 경우 "주말입니다."를 출력하세요.
        enum DayOfWeek {
            월, 화, 수, 목, 금, 토, 일
        }

        DayOfWeek day = DayOfWeek.valueOf(input);

        switch (day) {
            case 월:
            case 화:
            case 수:
            case 목:
            case 금:
                System.out.println("평일입니다.");
                break;
            case 토:
            case 일:
                System.out.println("주말입니다.");
                break;
        }

        // 2. 계절 Enum 활용하기
        System.out.println("\n===== 계절 Enum 활용하기 =====");
        System.out.println("월을 입력하세요 (1-12): ");
        int month = scanner.nextInt();

        // TODO: 입력받은 월에 해당하는 Season Enum 상수를 찾아 해당 계절의 특징을 출력하세요.
        // Season Enum에 평균 기온과 특징을 필드로 추가하고, 이를 활용하세요.

        Season season;
        switch (month) {
            case 3: case 4: case 5:
                season = Season.SPRING;
                break;
            case 6: case 7: case 8:
                season = Season.SUMMER;
                break;
            case 9: case 10: case 11:
                season = Season.FALL;
                break;
            case 12: case 1: case 2:
                season = Season.WINTER;
                break;
            default:
                System.out.println("올바른 월을 입력하세요.");
                return;
        }

        System.out.println("평균 기온: " + season.getAverageTemperature() + "도");
        System.out.println("특징: " + season.getDescription());

        // 3. 상태 전이 Enum 활용하기
        System.out.println("\n===== 상태 전이 Enum 활용하기 =====");

        // TODO: TaskStatus Enum을 구현하고, 상태 전이 로직을 활용하여 작업 상태를 변경하세요.
        // TaskStatus는 PENDING, IN_PROGRESS, COMPLETED, ARCHIVED 상태를 가지며,
        // nextStatus() 메소드를 통해 다음 상태로 전이할 수 있어야 합니다.
        // 사용자가 "next"를 입력할 때마다 상태를 다음 단계로 변경하고, 현재 상태를 출력하세요.
        // 사용자가 "exit"를 입력하면 종료합니다.
        TaskStatus status = TaskStatus.PENDING;

        System.out.println("작업 상태 관리 시작! (초기 상태: " + status + ")");
        System.out.println("\"next\"를 입력하면 다음 상태로 전이, \"exit\"을 입력하면 종료합니다.");

        while (true) {
            System.out.print("입력: ");
            String input2 = scanner.nextLine().trim().toLowerCase();

            if (input2.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (input2.equals("next")) {
                if (status == TaskStatus.ARCHIVED) {
                    System.out.println("현재 상태는 ARCHIVED이며 더 이상 전이할 수 없습니다.");
                } else {
                    status = status.nextStatus();
                    System.out.println("상태가 전이되었습니다. 현재 상태: " + status);
                }
            } else {
                System.out.println("올바른 명령어를 입력하세요. (next / exit)");
            }


        }

        // 4. 연산자 Enum 활용하기
        System.out.println("\n===== 연산자 Enum 활용하기 =====");
        scanner.nextLine(); // 버퍼 비우기

        // TODO: Operator Enum을 구현하고, 두 수에 대한 사칙연산을 수행하세요.
        // Operator는 ADD(+), SUBTRACT(-), MULTIPLY(*), DIVIDE(/) 연산을 가지며,
        // calculate() 메소드를 통해 두 수에 대한 연산을 수행할 수 있어야 합니다.
        // 사용자로부터 두 수와 연산자를 입력받아 계산 결과를 출력하세요.

        System.out.print("첫 번째 정수를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.print("두 번째 정수를 입력하세요: ");
        int num2 = scanner.nextInt();

        scanner.nextLine(); // 개행 문자 처리

        System.out.print("연산자를 입력하세요 (+, -, *, /): ");
        String opSymbol = scanner.nextLine().trim();

        try {
            Operator operator = null;
            for (Operator op : Operator.values()) {
                if (op.toString().equals(opSymbol)) {
                    operator = op;
                    break;
                }
            }

            if (operator == null) {
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
            }

            // 0으로 나누기 예외 처리
            if (operator == Operator.DIVIDE && num2 == 0) {
                System.out.println("오류: 0으로 나눌 수 없습니다.");
            } else {
                int result = operator.calculate(num1, num2);
                System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }


        scanner.close();
    }

    public enum DayOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    }

    enum Season {
        SPRING("꽃이 피는 계절", 15),
        SUMMER("더운 계절", 28),
        FALL("낙엽이 떨어지는 계절", 18),
        WINTER("추운 계절", 5);

        private final String description;
        private final int averageTemperature;

        // 생성자 (private이 기본값)
        Season(String description, int averageTemperature) {
            this.description = description;
            this.averageTemperature = averageTemperature;
        }

        // Getter 메소드
        public String getDescription() {
            return description;
        }

        public int getAverageTemperature() {
            return averageTemperature;
        }
    }

    // 상태 전이를 구현한 Enum 정의
    enum TaskStatus {
        READY {
            @Override
            public TaskStatus nextStatus() {
                return PENDING;
            }
        },
        PENDING {
            @Override
            public TaskStatus nextStatus() {
                return IN_PROGRESS;
            }
        },
        IN_PROGRESS {
            @Override
            public TaskStatus nextStatus() {
                return COMPLETED;
            }
        },
        COMPLETED {
            @Override
            public TaskStatus nextStatus() {
                return ARCHIVED;
            }
        },
        ARCHIVED {
            @Override
            public TaskStatus nextStatus() {
                return PENDING; // 다시 처음으로
            }
        };

        // 상태 전이를 위한 추상 메소드
        public abstract TaskStatus nextStatus();
    }

    // 추상 메소드가 있는 Enum 정의
    enum Operator {
        ADD("+") {
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        },
        SUBTRACT("-") {
            @Override
            public int calculate(int x, int y) {
                return x - y;
            }
        },
        MULTIPLY("*") {
            @Override
            public int calculate(int x, int y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            @Override
            public int calculate(int x, int y) {
                return x / y;
            }
        };

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

        // 추상 메소드 (각 상수에서 구현해야 함)
        public abstract int calculate(int x, int y);
    }

}