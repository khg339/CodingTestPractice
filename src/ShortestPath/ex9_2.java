package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ex9_2 {
    static class Node implements Comparable<Node>{ //노드 정보
        private int index;    //노드번호
        private int distance; //노드 까지의 거리

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override //우선 순위 설정
        public int compareTo(Node other){
            return this.distance - other.distance;
            //더 작은 값이 우선순위를 갖도록 설정
        }
    }
    static int N, M, C; //도시의 개수, 통로의 개수, 시작 노드
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); //각 노드에 인접한 노드에 대한 정보
    static int[] d = new int[30001]; //최단거리 저장

    static void dijkstra(int start){ //start 노드로부터의 거리 다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();

        //자기 자신까지의 거리 초기화
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){ //큐가 빌 때까지 반복
            Node node = pq.poll();
            int now = node.getIndex(); //가장 작은 값의 노드
            int dist = node.getDistance(); //가장 작은 값의 비용

            if(d[now] < dist) continue;

            for(int i=0; i<graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDistance(); //나를 거쳐 다른 노드로 이동하는 거리

                if(cost < d[graph.get(now).get(i).getIndex()]){ //나를 거쳐가는 값이 더 작다면
                    d[graph.get(now).get(i).getIndex()] = cost; //최단거리 교체
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost)); //우선순위 큐에 삽입
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt();

        //최단거리 초기화
        for(int i=0; i<=N; i++){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        //그래프 초기화
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<M; i++){ //간선 정보 입력
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();

            graph.get(X).add(new Node(Y, Z));
        }

        dijkstra(C); //C 로부터 최단거리 다익스트리 알고리즘

        int city = 0; //C가 보낼 수 있는 도시의 개수
        int time = 0; //C가 보내는 데 걸리는 시간

        for(int i=1; i<=N; i++){
            //C가 도달할 수 없거나 자기 자신이면 무시
            if(d[i] == Integer.MAX_VALUE || d[i] == 0) continue;

            //아니라면
            city++; //도시 수 증가
            time = Math.max(time, d[i]); //가능한 도시 중 최대 시간 저장
        }

        System.out.println(city + " " + time);
    }

}
