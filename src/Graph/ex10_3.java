package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class ex10_3 {

    static int N;
    static int[] parent;

    static int findParent(int n){ //n의 부모 찾기
        if(parent[n] == n ) return n; //루트노드라면 자기 자신 반환
        else return parent[n] = findParent(parent[n]); //재귀호출
    }

    static void union(int a, int b){ //a와 b 연결하기
        int na = findParent(a);
        int nb = findParent(b);

        if(na>nb) parent[a] = parent[b];
        else parent[b] = parent[a];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        parent = new int[N];

        for(int i=0; i<N; i++){ //부모노드를 자신으로 초기화
            parent[i] = i;
        }

        for(int i=0; i<N; i++){ //수업 연결
            String str = sc.nextLine();
            for(int j=0; j<N; j++){
                if(str.charAt(j) == '-') break;

            }
        }
    }
}
