package Graph;

import java.util.Scanner;

public class ex10_2 {

    static int N,M;
    static int[] parent = new int[N+1];
    static int[][] cost = new int[N+1][N+1];

    public static int findParent(int x){ //부모노드 찾기
        //루트노드가 아니라면 루트노드를 찾을 때까지 재귀
        if(x==parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b){ //두 노드 연결하기
        int n1 = findParent(a);
        int n2 = findParent(b);

        if(n1<n2) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=1; i<=N; i++){ //초기화
            for(int j=1; j<=N; j++){
                cost[i][j] = Integer.MAX_VALUE; //비용을 무한값으로 초기화
                if(i==j) cost[i][j] = 0; //만약 자기자신이면 비용 0
            }
            parent[i] = i; //부모노드 자기자신으로 초기화
        }

        for(int i=0; i<M; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            union(A,B); //A,B를 합치기
            cost[A][B] = C; //비용 입력
            cost[B][A] = C;
        }





    }
}
