package Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ex6_1 {  //숫자 입력받고 내림차순으로 정렬하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] num = new Integer[N];

        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }

        Arrays.sort(num, Collections.reverseOrder()); //내림차순 퀵정렬

        for(int i=0; i<N; i++){
            System.out.print(num[i] + " ");
        }
    }
}
