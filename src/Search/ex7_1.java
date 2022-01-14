package Search;

import java.util.Scanner;

public class ex7_1 {
    public static boolean find(int[] N, int start, int end, int x){ //N에 x가 있는지 찾는 이진탐색(재귀)
        int mid = (start+end)/2; //중간 인덱스

        if(x>N[mid]){ //오름차순된 배열의 중간값보다 x가 크면
            start = mid+1; //시작 인덱스를 중간인덱스 다음 값으로
            mid = (start+end)/2; //중간 인덱스 재정의
            find(N, start, end, x);//return될 때까지 재귀
        }
        else if(x>N[mid]){ //오름차순된 배열의 중간값보다 x가 작으면
            end = mid-1; //끝 인덱스를 중간인덱스 앞의 값으로
            mid = (start+end)/2; //중간 인덱스 재정의
            find(N, start, end, x); //return될 때까지 재귀
        }

        if(N[mid] == x) return true; //중간 인덱스 값이 x와 같아지면 true
        else return false; //같아지지않으면 false
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] n = new int[N]; //N개의 자연수 입력
        for(int i=0; i<N; i++){
            n[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] m = new int[M]; //M개의 자연수 입력
        for(int i=0; i<M; i++){
            m[i] = sc.nextInt();
        }

        for(int i=0; i<M; i++){ //m[i]가 배열 n에 있는지 찾기
            if(find(n, 0, N-1, m[i])) //true면 yes, false면 no
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }
}
