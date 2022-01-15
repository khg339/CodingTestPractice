package Dynamic;

import java.util.Scanner;

public class ex8_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //식량창고 개수
        int[] K = new int[N]; //식량의 개수
        for(int i=0; i<N; i++){
            K[i] = sc.nextInt(); //식량 개수 입력
        }

        int[] steal = new int[N];
        steal[0] = K[0];
        steal[1] = Math.max(steal[0], K[1]);

        for(int i=2; i<N; i++){ //피보나치 수열(보텀업)
            steal[i] = Math.max(steal[i-1], steal[i-2] + K[i]);
        }

        System.out.println(Math.max(steal[N-1], steal[N-2]));
    }
}
