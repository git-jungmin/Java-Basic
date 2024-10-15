import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task2_4 {
    public static void main(String[] args) {
        // 학생 정보 입력
        System.out.println("10명 학생의 학번과 점수 입력");

        int[] studentNumber = new int[10];  // 학번 저장 배열
        int[] grade = new int[10];  // 성적 저장 배열

        Scanner scanner = new Scanner(System.in);  // 생성자

        for(int i = 0; i < 10; i++){
            System.out.println((i+1) + ">>");
            String [] Student = scanner.nextLine().split(" ");
            studentNumber[i] = Integer.parseInt(Student[0]);  // studentNumber 값
            grade[i] = Integer.parseInt(Student[1]);  // grade 값
        }

        // 검색
        while(true){
            System.out.println("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");

            int search = scanner.nextInt(); // 검색 방법

            while (true){
                if(search == 1){  // 학번으로 검색
                    System.out.println("학번>>");
                    try{
                        int searchNumber = scanner.nextInt();  // 검색할 학번
                        for(int i = 0; i < 10; i++){  // 배열에서 찾기
                            if(studentNumber[i] == searchNumber){
                                System.out.println( grade[i] + "점");  // 찾았을 때
                                break;
                            }
                        }
                    } catch (InputMismatchException e){  // 예외처리
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.next();
                        continue;
                    }
                } else if(search == 2){  // 점수로 검색
                    System.out.println("점수>>");
                    try {
                        int searchScore = scanner.nextInt();
                        List<Integer> same = new ArrayList<>();
                        for(int i = 0; i < 10; i++){
                            if(grade[i] == searchScore){
                                same.add(i);
                            }
                        }
                        if(same.size() > 0){
                            System.out.println("점수가 " + searchScore + "인 학생은 ");
                            for(int i = 0; i < same.size(); i++){
                                System.out.println(same.get(i));
                            }
                            System.out.println("입니다.");
                        } else {
                            System.out.println("점수가 " + searchScore + "인 학생은 없습니다.");
                        }
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("정수를 입력하세요.");
                        scanner.next();
                        continue;
                    }
                } else if(search == 3) {
                    break;
                }
            }
            break;
        }
    }
}
