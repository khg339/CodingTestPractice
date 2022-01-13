import java.util.Scanner;

public class ex9_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] array = new int[N+1][N+1]; //NxN 테이블 생성
        for (int i = 1; i <= N; i++) { //모든 테이블의 값을 무한으로 초기화
            for (int j = 1; j <= N; j++) {
                array[i][j] = Integer.MAX_VALUE;
                if (i == j) array[i][j] = 0; //단, 자기자신을 가르킬 때는 0
            }
        }

        for (int i = 0; i < M; i++) { //M개의 연결 입력
            array[sc.nextInt()][sc.nextInt()] = 1;
        }

        //플로이드 위셜 알고리즘
        for(int k=1; k<=N; k++){ //1부터 N까지 반복하며 i부터 j까지의 시간과 i에서 k를 거쳐 j로 가는 시간 중 최소값 넣기
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    array[i][j] = Math.min(array[i][j], array[i][k] + array[k][j]);
                }
            }
        }

        int K = sc.nextInt();
        int X = sc.nextInt();

        System.out.println(array[1][K] + array[K][X]);
    }
}
