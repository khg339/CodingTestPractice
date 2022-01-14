package Implementation;

import java.util.Scanner;

public class ex4_2 {

    public static int N,M,A,B,d;
    public static int nA,nB,nd;
    public static int[][] map;
    public static int[][] direction = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public static int result = 1; //방문한 칸의 개수(결과)

    public static int turnLeft(int d){ //왼쪽으로 방향을 회전해주는 메서드
        if(d==0) return 3; //북쪽이 0이기 때문
        else return d-1;
    }

    public static boolean defaultMove(int A, int B, int d){ //캐릭터 기본 움직이기
        nd = turnLeft(d); //왼쪽으로 임의로 회전

        nA = A+direction[d][0]; //캐릭터를 임의로 전진
        nB = B+direction[d][1];

        if(nA<0 || nA>=N || nB<0 || nB>=M) return false;
        return true;
    }

    public static boolean backMove(int A, int B, int d){ //캐릭터 뒤로 움직이기
        nA = A-direction[d][0]; //캐릭터를 임의로 후진
        nB = B-direction[d][1];

        if(nA<0 || nA>=N || nB<0 || nB>=M) return false;
        return true;
    }

    public static void move(int A, int B, int d){
        if(defaultMove(A,B,d) == false) defaultMove(A,B,d);

        else {
            if (map[nA][nB] == 0) {
                result++;
                d = nd;
                A = nA;
                B = nB;
                System.out.println("go");
                System.out.println("replay");
                move(A, B, d);
            } else {
                if (d == nd) {
                    if (backMove(A, B, d) == false) return;
                    else{
                        if (map[nA][nB] == 0) {
                            result++;
                            A = nA;
                            B = nB;
                            System.out.println("replay");
                            move(A, B, d);
                        } else return;
                    }
                }
                defaultMove(A, B, d);
                System.out.println("replay");
                move(A, B, d);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //지도 세로크기
        int M = sc.nextInt(); //지도 가로크기
        int[][] map = new int[N][M];

        int A = sc.nextInt(); //캐릭터가 서있는 행
        int B = sc.nextInt(); //캐릭터가 서있는 열
        int d = sc.nextInt(); //캐릭터가 서있는 방향

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        move(A,B,d);
        System.out.println(result);

    }
}
