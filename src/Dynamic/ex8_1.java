package Dynamic;

import java.util.Scanner;

import static java.lang.Math.min;

public class ex8_1 { //1을 만드는 최소 방법
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int[] num = new int[30001];/*해당 숫자에서 최소방법 저장
                                     ex) num[4]=2, num[5]=1, num[6]=2*/

        for(int i=2; i<=X; i++){
            num[i] = num[i-1] + 1; //-1을 사용하는 경우 계산
            if(i%5==0) {//5로 나누어 떨어지다면
                num[i] = min(num[i], num[i/5]+1);//-1을 사용할 때, 5로 나눌 때 중 최소
            }
            else if(i%3==0){//3으로 나누어 떨어지다면
                num[i] = min(num[i], num[i/3]+1);//-1을 사용할 때, 3으로 나눌 때 중 최소
            }
            else if(i%2==0){//2로 나누어 떨어지다면
                num[i] = min(num[i], num[i/2]+1);//-1을 사용할 때, 2로 나눌 때 중 최소
            }
        }

        System.out.println(num[X]);
    }
}
