package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {  //우선순위 큐 사용

    static class Node implements Comparable<Node>{  //노드 객체

        private int index;    //노드 번호
        private int distance; //노드 까지의 거리(비용)

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        public int getIndex(){
            return this.index;
        }

        public int getDistance(){
            return this.distance;
        }

        //거리(비용)이 짧은(적은) 것이 높은 우선순위를 가짐
        @Override
        public int compareTo(Node other){
                return this.distance - other.distance;
                //오름차순 정렬을 생각하면 쉬움
        }
    }

    //노드의 개수(N), 간선의 개수(M), 시작 노드 번호(start)
    //노드의 최대 개수 100,000
    public static int n, m, start;

    //각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    //최단거리 테이블 만들기
    public static int[] d = new int[100001];

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(); //우선순위 큐

        //자기 자신까지의 최단거리는 0
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){ //큐가 비어있지 않다면
            // 가장 짧은 거리의 노드(현재노드) 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance(); //거리
            int now = node.getIndex(); //현재노드 번호

            //현재노드가 이미 처리된 적이 있다면 무시
            if(d[now] < dist) continue;

            //현재노드와 연결된 다른 노드들 확인
            for(int i=0; i<graph.get(now).size(); i++){
                //cost는 현재 노드를 거쳐서 i 노드로 이동하는 거리
                int cost = d[now] + graph.get(now).get(i).getDistance();
                //현재노드를 거쳐 다른 노드로 이동하는 거리가 더 짧다면
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost; //최단거리 바꾸기
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost)); //우선순위 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //그래프 초기화
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Node>());
        }

        //모든 간선의 정보 입력받기
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            //a에서 b까지의 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        //최단거리 테이블 무한으로 초기화
        Arrays.fill(d, Integer.MAX_VALUE);

        //다익스트라 알고리즘 수행
        dijkstra(start);

        //모든 노드로 가기 위한 최단거리 출력
        for(int i=1; i<=n; i++){
            //도달할 수 없다면 INFINITY 로 출력
            if(d[i] == Integer.MAX_VALUE){
                System.out.println("INFINITY");
            }
            else{ //도달할 수 있다면 최단거리 출력
                System.out.println(d[i]);
            }
        }
    }

}
