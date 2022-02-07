package DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {

    public static boolean[] visited = new boolean[9]; //방문기록
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    //bfs 함수 정의
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        //현재 노드를 방문 처리
        visited[start] = true;

        //큐가 빌 때까지
        while(!q.isEmpty()){
            //큐에서 하나의 원소를 뽑아 출력
            int x = q.poll();
            System.out.print(x + " ");

            //해당 원소와 연결된, 아직 방문하지 않은 원소를 큐에 삽입
            for(int i=0; i<graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if(!visited[y]){
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        //그래프 초기화
        for(int i=0; i<9; i++){
            graph.add(new ArrayList<Integer>());
        }

    }

}
