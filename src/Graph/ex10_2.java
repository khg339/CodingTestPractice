package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex10_2 {

    static int[] parent; //부모노드

    static class Edge{ //간선

        private int home1;
        private int home2;
        private int cost;


        public Edge(int home1, int home2, int cost) {
            this.home1 = home1;
            this.home2 = home2;
            this.cost = cost;
        }

        public int getHome1() {
            return home1;
        }
        public int getHome2() {
            return home2;
        }
        public int getCost() {
            return cost;
        }
    }

    static int findParent(int x){ //부모 노드를 찾기(루트노드일 때까지)
        if(x == parent[x]) return x; //루트노드라면
        return parent[x] = findParent(parent[x]);
    }

    static void union(int a, int b){ //두 노드 연결하기
        int na = findParent(a);
        int nb = findParent(b);

        if(na<nb) parent[nb] = parent[na];
        else parent[na] = parent[nb];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //집의 개수
        int M = sc.nextInt(); //길의 개수

        Edge[] edge = new Edge[M]; //간선의 정보
        for(int i=0; i<M; i++){
            edge[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        //부모 노드 자기 자신으로 초기화
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        //간선(길)을 비용이 적은 순으로 정렬
        Arrays.sort(edge, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        int result = 0; //비용 최솟값 결과
        int last = 0;   //최소 비용 트리에서 제일 비싼 간선 비용

        for(int i=0; i<M; i++){
            //연결된 두 집의 부모가 같지 않을 때만
            if(findParent(edge[i].getHome1()) != findParent(edge[i].getHome2())){
                union(edge[i].getHome1(), edge[i].getHome2()); //두 노드 연결하기
                result = result + edge[i].getCost(); //비용 더하기
                last = edge[i].getCost(); //비용순으로 edge가 정렬되었기 때문에 루프가 끝난 후 제일 비싼 값이 저장됨
            }
        }

        System.out.println(result - last); //최소비용 트리에서 제일 비싼 비용을 빼면, 두 개로 분리됨
    }
}
