public class ShapeEx {
    static public void main(String[] args) {
        Shape[] list = new Shape[3]; // Shape을 상속받은 클래스 객체의 레퍼런스 배열
        list[0] = new Circle(5); // 반지름이 5인 원
        list[1] = new Oval(20,30); // 20x30 사각형에 내접하는 타원
        list[2] = new Rect(10,40); // 10x40 크기의 사각형
        for(int i = 0; i < list.length; i++) list [i].redraw();
        for(int i = 0; i < list.length; i++) System.out.println("면적은 " + list[i].getArea());
    }
}

interface Shape { // Shape 인터페이스 구현
    final double PI = 3.14;
    void draw(); // 도형 그리기
    double getArea(); // 면적을 반환
    default public void redraw() { // 도형 다시 그리기 메소드
        System.out.println("--- 다시 그립니다.");
        draw(); // 도형 그리기 호출
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) { // 생성자: 변수 초기화
        this.radius = radius;
    }
    public void draw() {

    }

}

class Oval implements Shape {}

class Rect implements Shape {}

