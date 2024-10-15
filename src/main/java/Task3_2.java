public class Task3_2 {
    public static void main(String[] args) {
        Rectangle a = new Rectangle(3,3,6,6);  // 사각형 a 객체
        Rectangle b = new Rectangle(4,4,2,3);  // 사각형 b 객체

        a.show();  // 정보 출력
        if(a.isSquare()){  // isSquare 메소드 호출
            System.out.println("a는 정사각형입니다.");  // 정사각형일 때
        } else System.out.println("a는 직사각형입니다.");  // 정사각형이 아닐 때
        if(a.contains(b)) System.out.println("a는 b를 포함합니다.");  // contains 메소드 호출
    }

    static class Rectangle {
        int x, y, width, height;

        // 생성자 변수 초기화
        public Rectangle(int x, int y, int width, int height) {
            this.x = x;  // 점 x
            this.y = y;  // 점 y
            this.width = width;  // 넓이
            this.height = height;  // 높이
        }

        boolean isSquare() {  // 정사각형 유무
            return width == height;  // 높이와 넓이가 같다면
        }

        boolean contains(Rectangle r) {  // 매개변수로 받은 사각형이 해당 사각형 내에 있는지
            return x < r.x && y < r.y && x+width > r.x+r.width && y+height > r.y+r.height;
        }

        public void show(){  // 사각형 정보
            System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
        }
    }
}
