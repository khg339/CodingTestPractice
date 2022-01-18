package Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ex6_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        //배열 입력
        Integer[] A = new Integer[N];
        for(int i=0; i<N; i++) A[i] = sc.nextInt();
        Integer[] B = new Integer[N];
        for(int i=0; i<N; i++) B[i] = sc.nextInt();

        Arrays.sort(A); //오름차순 정렬
        Arrays.sort(B, Collections.reverseOrder()); //내림차순 정렬

        for(int i=0; i<K; i++){ //K번 반복
            if(A[i] < B[i]){
                //B가 A보다 크면 바꾸기
                int tmp = A[i];
                A[i] = B[i];
                B[i] = A[i];
            }
        }

        int sum = 0;
        for(int i=0; i<N; i++){ //A의 모든 값 더하기
            sum += A[i];
        }

        System.out.println(sum);

    }
}
