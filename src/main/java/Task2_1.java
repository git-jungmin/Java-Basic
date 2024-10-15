import java.util.Scanner;
import java.util.Random;

public class Task2_1 {

    public static void main(String[] task2_1){

        System.out.println("***** 작명 프로그램이 실행됩니다. *****");

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("남/여 선택>>");
            String gender = scanner.nextLine();  // 사용자가 입력한 텍스트 성별 읽어 오기

            String middle;  // 중간 문자 저장 변수
            String last;  // 마지막 문자 저장 변수

            if( gender.equals("남") || gender.equals("여") ) {
                Name name = new Name(gender);
                middle = name.Middle();
                last = name.Last();
            } else if( gender.equals("그만") ) {
                break;
            } else {
                System.out.println("남/여/그만 중에서 입력하세요!");
                continue;
            }

            System.out.println("성 입력>>");
            String first = scanner.nextLine();  // 사용자가 입력한 텍스트 성 읽어 오기

            System.out.println( "추천 이름: " + first + middle + last );
        }

        scanner.close();
    }

    static class Name {
        private String gender;

        String boyMiddleList [] = { "기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지" };
        String boyLastList [] = { "태", "진", "광", "혁", "우", "철", "빈", "준", "구", "호", "석" };

        String girlMiddleList [] = { "은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하" };
        String girlLastList [] = { "진", "연", "경", "서", "리", "숙", "미", "원", "린", "희", "수" };

        Random random = new Random();  // 랜덤 객체 생성

        public Name(String gender) {  // 생성자
            this.gender = gender;
        }

        // 중간 문자
        public String Middle() {
            int randomMiddle;

            if( gender.equals("남") ){ // 남자일때
                randomMiddle = random.nextInt(boyMiddleList.length);  // boyMiddleList 크기의 랜덤 인덱스 추출
                return boyMiddleList[randomMiddle];  // List 크기에 따른 랜덤 인덱스 위치의 문자 저장
            } else {  // 여자일때
                randomMiddle = random.nextInt(girlMiddleList.length);  // girlMiddleList 크기의 랜덤 인덱스 추출
                return girlMiddleList[randomMiddle];  // List 크기에 따른 랜덤 인덱스 위치의 문자 저장
            }
        }

        // 마지막 문자
        public String Last() {
            int randomIndexLast;

            if( gender.equals("남") ){ // 남자일때
                randomIndexLast = random.nextInt(boyLastList.length);  // boyLastList 크기의 랜덤 인덱스 추출
                return boyLastList[randomIndexLast];  // List 크기에 따른 랜덤 인덱스 위치의 문자 저장
            } else {  // 여자일때
                randomIndexLast = random.nextInt(girlLastList.length);  // girlLastList 크기의 랜덤 인덱스 추출
                return girlLastList[randomIndexLast];  // List 크기에 따른 랜덤 인덱스 위치의 문자 저장
            }
        }
    }
}
