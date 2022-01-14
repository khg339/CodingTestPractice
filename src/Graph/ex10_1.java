package Graph;

import java.util.Scanner;

public class ex10_1 {
    public static int[] parent = new int[100001];//부모테이블(팀)(1<= N <= 100,000)

    //특정 노드가 속한 집합 찾기
    public static int findParent(int x){
        //노드를 찾을 때까지 재귀적
        if(x==parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }
    //팀을 합치는 메소드(합집합)
    public static void unionParent(int n1, int n2){
        n1 = findParent(n1);
        n2 = findParent(n2);
        if(n1<n2) parent[n2] = n1;
        else parent[n1] = n2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //노드의 개수(학생들의 번호)
        int M = sc.nextInt(); //연산의 개수

        //부모를 자기 자신으로 초기화(팀을 자기 자신으로)
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        //연산
        for(int i=0; i<M; i++){
            int type = sc.nextInt();
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();

            //팀을 합친다(합집합)
            if(type==0){
                unionParent(p1, p2);
            }
            //같은 팀 여부 확인(찾기)
            else if(type==1){
                if(findParent(p1) == findParent(p2))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }


    }
}
