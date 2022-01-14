package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ex3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] data = new int[1001];

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] n = new int[N]; //N개의 자연수 입력
        for(int i=0; i<N; i++){
            n[i] = sc.nextInt();
        }

        Arrays.sort(n); //오름차순 정렬

        int first = n[N-1];
        int second = n[N-2];
        int result = 0;

        while(true){
            if(M==0) break; //M번 연산하면 반복문 탈출
            else if(M<=K){ //남은 연산이 K보다 작거나 같으면
                result = result + (first * M); //제일 큰 수를 남은 연산만큼 더하기
                M = 0;
            }
            else { //남은 연산이 K보다 크면
                result = result + (first * K); //K번 제일 큰 수를 더하고
                M = M - K;
                result = result + second; //두번째로 큰 수를 더하기
                M = M - 1;
            }
        }

        System.out.println(result);
    }
}
