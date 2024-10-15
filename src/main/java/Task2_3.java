import java.util.Scanner;

public class Task2_3 {
    public static void main(String[] args) {
        String coffee[] = { "핫아메리카노", "아이스아메리카노", "카푸치노", "라떼" };
        int price[] = { 3000, 3500, 4000, 5000 };

        System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");

        while (true){
            System.out.println("주문>>");

            Scanner scanner = new Scanner(System.in);  // 생성자
            String order = scanner.nextLine();  // 입력 데이터 읽기

            String[] orders = order.split(" ");  // 공백을 기준으로 배열에 저장
            String menu = orders[0];  // 메뉴 저장
            boolean exit = false;  // 메뉴 존재 여부 확인 변수
            int count = 0;  // 개수 변수
            int total = 0;  // 전체 가격

            if(order.equals("그만")){  // 입력 값이 그만일 때
                break;  // 종료
            } else {
                for(int i = 0; i < coffee.length; i++) {  // coffee 배열에서 메뉴 확인
                    if (coffee[i].equals(orders[0])) {
                        exit = true;  // 존재함

                        try{
                            count = Integer.parseInt(orders[1]);  // 개수 값 저장
                        } catch (NumberFormatException e){  // 예외 발생
                            System.out.println("잔 수는 정수로 입력해주세요!");
                            continue;  // 처음부터
                        }

                        total = price[i] * count;  // 전체 가격 계산
                        System.out.println("가격은 " + total + "원 입니다.");
                        break;
                    }
                }

            }

            if(!exit){  // 없는 메뉴일 때
                System.out.println( orders[0] + "는(은) 없는 메뉴입니다." );
            }
        }

    }
}
