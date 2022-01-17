package Search;

import java.util.Arrays;
import java.util.Scanner;

public class ex7_2 {

    static int N,M;
    static int h; //절단기의 높이
    static int[] rice_h; //떡의 개별 높이

    public static int searchMaxHeight(int start, int end){ //자를 수 있는 가장 긴 떡 찾기(이진탐색)

        if(start>end) return -1; //종료 조건

        int mid = (start+end)/2;
        int sum = 0; //손님에게 줄 수 있는 떡

        for(int i=0; i<N; i++){ //떡의 길이가 기준 값보다 길면 손님에게 줄 수 있음
            if(rice_h[i] > mid) sum += (rice_h[i] - mid);
        }

        //손님에게 줄 수 있는 양을 만족한다면
        if(sum>=M) return Math.max(mid, searchMaxHeight(mid+1, end)); //최대길이 찾기
        else return searchMaxHeight(start, mid-1); //기준 값을 낮춰 이진탐색
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //떡의 개수
        M = sc.nextInt(); //요청한 떡의 길이

        rice_h = new int[N]; //떡의 개별 높이
        for(int i=0; i<N; i++){
            rice_h[i] = sc.nextInt();
        }

        Arrays.sort(rice_h); //오름차순 정렬
        int high = rice_h[N-1]; //제일 긴 떡

        System.out.println(searchMaxHeight(0, high));
    }
}
