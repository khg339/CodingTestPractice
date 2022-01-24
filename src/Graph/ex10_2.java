package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex10_2 {

    static int[] parent; //각 노드의 부모노드 저장

    public static class Edge{ //간선의 정보를 저장하는 객체
        private int n1;
        private int n2;
        private int cost; //n1에서 n2까지의 거리(비용)

        public Edge(int n1, int n2, int cost) {
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }

        public int getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }

        public int getCost() {
            return cost;
        }
    }

    static int findParent(int x){ //x의 최상위 부모를 찾는 메서드
        if(x == parent[x]) return x; //자신이 루트노드라면 자신 반환
        return parent[x] = findParent(parent[x]); //아니라면 루트노드를 찾을 때까지 올라가기
    }

    static void union(int a, int b){ //a 노드와 b 노드를 합치는 메서드
        int na = findParent(a);
        int nb = findParent(b);

        if(na>nb) parent[na] = nb;
        else parent[nb] = na;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //집의 개수
        int M = sc.nextInt(); //길의 개수

        //부모 노드 자기 자신으로 초기화
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        Edge[] edges = new Edge[M]; //간선의 정보 입력
        for(int i=0; i<M; i++){
            int A = sc.nextInt(); //첫번째 집
            int B = sc.nextInt(); //두번째 집
            int C = sc.nextInt(); //두 집을 연결하는 비용
            edges[i] = new Edge(A, B, C);
        }

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) { //간선의 비용을 기준으로 오름차순 정렬
                return o1.getCost() - o2.getCost();
            }
        });

        int last = 0; //연결된 최소신장트리에서 가장 비싼 비용
        int result = 0; //최종 비용

        for(int i=0; i<M; i++){
            int a = edges[i].getN1();
            int b = edges[i].getN2();
            int cost = edges[i].getCost();

            if(findParent(a)!= findParent(b)){ //두 부모가 다를 경우(사이클이 발생하지 않는 경우)
                union(a, b); //두개를 합친다
                result += cost; //비용을 더해준다
                last = cost; //비용순으로 오름차순 정렬이 되어있기 때문에 가장 비싼 값이 마지막에 들어감
            }
        }

        System.out.println(result - last); //제일 비싼 길을 끊어준다

    }

}
