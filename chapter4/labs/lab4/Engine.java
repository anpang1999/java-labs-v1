package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Engine 클래스 정의하기
 */
public class Engine {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (엔진 타입, 마력, 작동 상태 등)

    private String type;      // 엔진 타입 (가솔린, 디젤, 전기 등)
    private int horsePower;   // 마력
    private boolean running;  // 작동 상태
    
    // TODO: 생성자를 정의하세요.

    public Engine(String type, int horsePower) {
        this.type = type;
        this.horsePower = horsePower;
        this.running = false;
    }
    
    // TODO: 엔진을 시작하는 메소드를 정의하세요.

    public void start() {
        if (!running) {
            running = true;
            System.out.println(type + " 엔진 시동을 걸었습니다. (" + horsePower + "hp)");
        } else {
            System.out.println("이미 엔진이 가동 중입니다.");
        }
    }
    
    // TODO: 엔진을 정지하는 메소드를 정의하세요.

    public void stop() {
        if (running) {
            running = false;
            System.out.println(type + " 엔진을 정지했습니다.");
        } else {
            System.out.println("이미 엔진이 정지해 있습니다.");
        }
    }
    
    // TODO: 엔진의 상태를 확인하는 메소드를 정의하세요.

    public boolean isRunning() {
        return running;
    }
    
    // TODO: 엔진의 정보를 출력하는 메소드를 정의하세요.

    public void displayInfo() {
        System.out.println("엔진 타입: " + type);
        System.out.println("마력: " + horsePower + "hp");
        System.out.println("상태: " + (running ? "가동 중" : "정지"));
    }

    // TODO: 필요한 getter/setter 메소드를 정의하세요.

    public String getType() {
        return type;
    }

    public int getHorsePower() {
        return horsePower;
    }
} 