import java.util.Scanner;

public class Task2_2 {
    public static void main(String[] args) {
        String course [] = { "C", "C++", "Python", "Java", "HTML" };
        String grade [] = { "A", "B+", "B", "A+", "D" };

        while (true) {
            Scanner scanner = new Scanner(System.in);  // scanner 객체 생성
            System.out.println("과목>>");
            String courseName = scanner.nextLine();  // 사용자 입력
            boolean exit = false;  // 입력한 값이 course 배열 내 존재 유무 저장 변수

            for(int i = 0; i < course.length; i++) {  // 배열을 순차적으로 확인하며 같은 값이 있는지 확인
                if (course[i].equals(courseName)) {  // course 배열에서 동일 값을 찾았을 때
                    System.out.println(courseName + " 학점은 " + grade[i] + "입니다.");  // grade 배열에서 같은 인덱스 위치에 있는 값 출력
                    exit = true;  // 동일 값 존재한다고 저장
                    break;
                }
            }

            if(!exit) {  // course 베열에 값이 없을 때
                if (courseName.equals("그만")) {  // course 배열에 값이 없지만 그만일 때
                    break;  // 반복문 종료
                } else {  // course 배열에 값도 없고 그만도 아닐 때
                    System.out.println(courseName + "는(은) 없는 과목입니다.");
                    continue;  // 처음부터 반복문 시작
                }
            }
        }
    }
}