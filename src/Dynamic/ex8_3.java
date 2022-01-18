package Dynamic;

import java.util.Scanner;

public class ex8_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] cases = new int[N+1]; //경우의 수 저장
        cases[1] = 1; //2X1을 덮을 경우의 수
        cases[2] = 3; //2X2를 덮을 경우의 수

        //보텀업
        for(int i=3; i<=N; i++){
            // 2*i를 덮을 경우의 수는 i-1의 경우에 2X1을 추가한 것과
            // i-2의 경우에 1X2두 개 or 2X2를 추가한 값이다.
            cases[i] = ( cases[i-2]*2 + cases[i-1] )%796796;
        }

        System.out.println(cases[N]);
    }
}
