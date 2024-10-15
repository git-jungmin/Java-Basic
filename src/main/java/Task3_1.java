public class Task3_1 {
    class Song {  // static으로 class를 정의
        private String title;  // 노래 제목
        private String singer;  // 가수 이름
        private int year;  // 발표 년도
        private String lang;  // 가수 나라

        // 생성자 : Song 객체 생성 시 값을 초기화
        public Song(String title, String singer, int year, String lang) {
            this.title = title;
            this.singer = singer;
            this.year = year;
            this.lang = lang;
        }

        // 노래 정보 출력
        public void show() {
            System.out.println(year + "년 " + lang + "의 " + singer + "가 부른 " + title);
        }
    }

    // main 메서드
    public static void main(String[] args) {
        Task3_1 task3 = new Task3_1();  // 외부 클래스 Task3_1의 인스턴스 생성
        Song song = task3.new Song("가로수 그늘 아래 서면", "이문세", 1988, "한국");  // 외부 인스턴스를 통해 객체 생성
        song.show();  // Song 객체의 show 메서드 호출
    }
}
