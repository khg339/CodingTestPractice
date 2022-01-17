package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ex3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //행의 개수
        int M = sc.nextInt(); //열의 개수

        int[][] card = new int[N][M]; //놓여진 카드
        int[] min = new int[N]; //각 줄의 제일 작은 카드
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                card[i][j] = sc.nextInt(); //카드 입력
            }
            //한줄이 입력될 때마다
            Arrays.sort(card[i]); //오름차순 정렬
            min[i] = card[i][0];  //가장 첫번째 카드를 min에 넣어줌
        }

        Arrays.sort(min); //최소값들을 오름차순 정렬

        System.out.println(min[min.length-1]); //가장 마지막 값이 최소값 중 최대값

    }
}
