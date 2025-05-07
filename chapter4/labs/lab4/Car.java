package chapter4.labs.lab4;

import chapter4.examples.ex6.Engine;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Car 클래스 정의하기 (Engine을 포함하는 관계)
 */
public class Car {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (모델명, 색상, 속도, Engine 타입의 필드 등)
    private String model;     // 모델명
    private String color;     // 색상
    private Engine engine;    // 엔진 (포함 관계: Car has-a Engine)
    private int speed;


    // TODO: 생성자를 정의하세요.
    // (Engine 객체를 생성하여 포함관계 구현)

    public Car(String model, String color, String engineType, int horsePower) {
        this.model = model;
        this.color = color;
        // 자동차 생성 시 엔진 객체도 함께 생성 (has-a 관계)
        this.engine = new Engine(engineType, horsePower);
        this.speed = 0;
    }
    
    // TODO: 자동차를 시동하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 메소드 호출)

    public void start() {
        System.out.println(model + " 시동을 겁니다.");
        // Car 객체가 Engine 객체의 메소드 호출
        engine.start();
    }
    
    // TODO: 자동차를 정지하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 메소드 호출)

    public void stop() {
        if (speed > 0) {
            System.out.println("먼저 차를 멈춰야 합니다.");
            return;
        }

        System.out.println(model + " 시동을 끕니다.");
        engine.stop();
    }
    
    // TODO: 자동차의 속도를 증가시키는 메소드를 정의하세요.

    public void accelerate(int amount) {
        if (!engine.isRunning()) {
            System.out.println("시동이 꺼져 있어 가속할 수 없습니다.");
            return;
        }

        speed += amount;
        System.out.println(amount + "km/h 가속했습니다. 현재 속도: " + speed + "km/h");
    }
    
    // TODO: 자동차의 속도를 감소시키는 메소드를 정의하세요.

    public void brake(int amount) {
        if (speed - amount < 0) {
            speed = 0;
        } else {
            speed -= amount;
        }

        System.out.println(amount + "km/h 감속했습니다. 현재 속도: " + speed + "km/h");
    }
    
    // TODO: 자동차의 정보를 출력하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 정보도 출력)

    public void displayInfo() {
        System.out.println("\n===== 자동차 정보 =====");
        System.out.println("모델: " + model);
        System.out.println("색상: " + color);
        System.out.println("현재 속도: " + speed + "km/h");
        System.out.println("------ 엔진 정보 ------");
        engine.displayInfo();
        System.out.println("=====================");
    }
    
    // TODO: 필요한 getter/setter 메소드를 정의하세요.

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public Engine getEngine() {
        return engine;
    }
} 