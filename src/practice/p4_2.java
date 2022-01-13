package practice;

import java.util.Scanner;

public class p4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        for(int i=0; i<=N; i++){ //시간
            for(int j=0; j<60; j++){ //분
                for(int k=0; k<60; k++){ //초
                    String time = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
                    if(time.contains("3")) count++; //3이 있으면 count
                }
            }
        }

        System.out.println(count);
    }
}
