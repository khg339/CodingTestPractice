package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class ex8_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //화폐의 종류
        int M = sc.nextInt(); //가치의 합

        int[] count = new int[10001]; //화폐 사용 개수 저장
        Arrays.fill(count, 10001); //화폐 최대 금액이 10000이므로, 가작 작은 단위 1일 때 10000이다.

        int[] money = new int[N]; //화폐의 가치 입력
        for(int i=0; i<N; i++){
            money[i] = sc.nextInt();
            count[money[i]] = 1; //해당 가치에선 1개만 사용
        }


        //다이나믹 프로그래밍(보텀업)
        count[0] = 0; //0원을 세는 화폐의 개수는 0개
        for(int i=0; i<N; i++){ //i는 화폐의 종류를 바꿔줌
            for(int j= money[i]; j<=M; j++){ //바뀌는 화폐의 값부터 M까지 반복
                if(count[j - money[i]] < 10001){ //현재 화폐 사용이 가능하다면
                    //현재 개수와 화폐를 사용하는 경우 중 작은 값 저장
                    count[j] = Math.min(count[j], count[j-money[i]] + 1);
                }
            }
        }


        if(count[M] <= 10000) System.out.println(count[M]); //10000보다 작거나 같으면 가능한 경우
        else System.out.println(-1); //10000초과면 불가능

    }

}
