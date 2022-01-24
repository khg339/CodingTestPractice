package Greedy;

import java.util.Scanner;

public class ex3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] minNum = new int[N+1]; //각 숫자의 최소 횟수 저장
        minNum[1] = 0;


        for(int i=2; i<=N; i++){
            //-1을 할 경우
            minNum[i] = minNum[i-1] + 1;

            if(i%K == 0){ //i가 K로 나눠지는 경우
                minNum[i] = Math.min(minNum[i], minNum[i/K] + 1); //-1을 할 경우와 K로 나눌 때 중 작은 값 저장
            }
        }

        System.out.println(minNum[N]);

    }
}
