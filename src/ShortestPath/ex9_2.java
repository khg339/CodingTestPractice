package ShortestPath;

import java.util.Scanner;

public class ex9_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //도시의 개수
        int M = sc.nextInt(); //통로의 개수
        int C = sc.nextInt(); //메세지를 보내고자 하는 도시

        int[][] time = new int[N+1][N+1]; //a에서 b로 이동하는 최단시간 저장
        for(int i=1; i<=N; i++){ //무한으로 초기화
            for(int j=1; j<=N; j++){
                time[i][j] = Integer.MAX_VALUE;
                if(i==j) time[i][j] = 0; //자기 자신인 경우 0으로 초기화
                //System.out.println("time[" + i + "][" + j + "]=" + time[i][j]);
            }
        }

        for(int i=0; i<M; i++){ //통로 입력
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();
            time[X][Y] = Z;
            //System.out.println("time[" + X + "][" + Y + "]=" + time[X][Y]);
        }

        for(int k=1; k<=N; k++){ //플로이드위셜 알고리즘으로 최단시간 저장
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    time[i][j] = Math.min(time[i][j], time[i][k] + time[k][j]);
                    System.out.println("time[" + i + "][" + j + "]=" + time[i][j]);
                }
            }
        }

        int city = 0; //C에서 보낸 메세지를 받는 도시 수
        int total = 0; //C에서 메세지를 보내는데 걸리는 시간

        for(int i=1; i<=N; i++){
            System.out.println(time[C][i]);
            if(time[C][i] < Integer.MAX_VALUE && time[C][i] > 0) {
                city++;
                total = Math.max(total, time[C][i]);
            }
        }

        System.out.println(city + " " + total);
    }
}
