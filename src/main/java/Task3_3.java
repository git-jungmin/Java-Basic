import java.util.Scanner;

public class Task3_3 {
    public static void main(String[] args) {
        System.out.println("명품 콘서트 홀 예약 시스템입니다.");
        Consert consert = new Consert();  // 콘서트 예약 시스템 객체 생성
        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성

        while(true) {
            try {
                System.out.println("예약:1, 조회:2, 취소:3, 끝내기:4>>");
                int menu = scanner.nextInt();  // 메뉴 번호 입력

                if(menu == 1){  // 예약일 때
                    try {
                        System.out.println("좌석구분 S(1), A(2), B(3)>>");
                        int type = scanner.nextInt();  // 좌석 타입 입력
                        if(type < 1 || type > 3){
                            throw new Exception("존재하지 않는 좌석 타입입니다.");
                        } else {
                            consert.Present(type);  // 현재 좌석 상태 출력하는 메서드 호출

                            System.out.println("이름>>");
                            String name = scanner.next();  // 이름 입력

                            System.out.println("번호>>");
                            int seat = scanner.nextInt();  // 좌석 번호 입력

                            if(seat < 1 || seat > 10){
                                throw new Exception("존재하지 않는 좌석입니다.");
                            } else {
                                if(!consert.Empty(type, seat)){
                                    throw new Exception("해당 좌석은 예약할 수 없습니다.");
                                } else {
                                    consert.Reservation(type, name, seat);  // 예약 메서드 호출
                                }
                            }
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                } else if(menu == 2){  // 조회일 때
                    consert.Reference();  // 조회 메서드 호출
                    System.out.println("<<<조회를 완료하였습니다.>>>");

                } else if(menu == 3){  // 취소일 때
                    System.out.println("좌석 S:1, A:2, B:3>>");
                    int type = scanner.nextInt();  // 좌석 타입 입력
                    consert.Present(type);  // 현재 좌석 상태 출력하는 메서드 호출

                    System.out.println("이름>>");
                    String name = scanner.next();  // 이름 입력
                    consert.Cancel(type, name);  // 예약 취소 메서드 호출

                } else if(menu == 4){  // 시스템 종료
                    break;
                } else {
                    throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    static class Consert{
        static String[] S = new String[10];  // S 배열 생성
        static String[] A = new String[10];  // A 배열 생성
        static String[] B = new String[10];  // B 배열 생성

        public Consert() {  // 배열 초기화
            for(int i = 0; i < 10; i++){
                S[i] = "___ ";
                A[i] = "___ ";
                B[i] = "___ ";
            }
        }

        public void Present(int type){  // 현재 좌석 상태
            if(type == 1){  // S 좌석 선택했을 때
                System.out.print("S>> ");
                for(int i = 0; i < 10; i++){  // S 좌석 전체 출력
                    System.out.print(S[i]);
                }
            } else if(type == 2){  // A 좌석 선택했을 때
                System.out.print("A>> ");
                for(int i = 0; i < 10; i++){  // A 좌석 전체 출력
                    System.out.print(A[i]);
                }
            } else if(type == 3){  // B 좌석 선택했을 때
                System.out.print("B>> ");
                for(int i = 0; i < 10; i++){  // B 좌석 전체 출력
                    System.out.print(B[i]);
                }
            }
            System.out.println(" ");
        }

        public boolean Empty(int type, int seat){  // 좌석이 비어있는 지 확인
            if(type == 1){
                return S[seat].equals("___ ");
            } else if(type == 2){
                return A[seat].equals("___ ");
            } else if(type == 3){
                return B[seat].equals("___ ");
            } else {
                return false;
            }
        }

        public void Reservation(int type, String name, int seat) {  // 예약하기 메서드
            if(type == 1){  // S 좌석 선택했을 때
                S[seat-1] = name + " ";  // S 좌석에 이름 저장
            } else if(type == 2){  // A 좌석 선택했을 때
                A[seat-1] = name + " ";  // A 좌석에 이름 저장
            } else if(type == 3){  // B 좌석 선택했을 때
                B[seat-1] = name + " ";  // B 좌석에 이름 저장
            }
        }

        public void Reference(){  // 조회하기 메서드
            System.out.print("S>> ");
            for(int i = 0; i < 10; i++){  // S좌석 전체 출력
                System.out.print(S[i]);
            }
            System.out.println(" ");
            System.out.print("A>> ");
            for(int i = 0; i < 10; i++){  // A좌석 전체 출력
                System.out.print(A[i]);
            }
            System.out.println(" ");
            System.out.print("B>> ");
            for(int i = 0; i < 10; i++){  // B좌석 전체 출력
                System.out.print(B[i]);
            }
            System.out.println(" ");
        }

        public void Cancel(int type, String name){  // 취소하기 메서드
            if(type == 1){  // S 좌석일 때
                for(int i = 0; i < 10; i++){
                    if(S[i].equals(name)){  // 배열에서 입력 이름과 같은 이름을 찾았을 때
                            S[i] = "___ ";  // 이름을 언더바로 대체
                    }
                }
            } else if(type == 2){  // A 좌석일 때
                for(int i = 0; i < 10; i++){
                    if(A[i].equals(name)){  // 배열에서 입력 이름과 같은 이름을 찾았을 때
                        A[i] = "___ ";  // 이름을 언더바로 대체
                    }
                }
            } else if(type == 3){  // B 좌석일 때
                for(int i = 0; i < 10; i++){
                    if(B[i].equals(name)){  // 배열에서 입력 이름과 같은 이름을 찾았을 때
                        B[i] = "___ ";  // 이름을 언더바로 대체
                    }
                }
            }
        }
    }
}
