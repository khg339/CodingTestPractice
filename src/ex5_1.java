import java.util.Scanner;

public class ex5_1 {

    public static int N, M;
    public static int[][] ice = new int[1000][1000]; //얼음틀

    public static boolean dfs(int x, int y){ //깊이우선탐색으로 얼음 찾기
        if(x<0 || x>=N || y<0 || y>=M) return false; //벗어남
        if(ice[x][y] == 0){ //0이면
            ice[x][y] = 1; //지워주고

            dfs(x+1, y); //상
            dfs(x-1, y); //하
            dfs(x, y-1); //좌
            dfs(x, y+1); //우

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); //nextInt()뒤에 nextLine()쓸 때 엔터를 읽는 것을 막기 위해 사용

        for(int i=0; i<N; i++){ //얼음 채우기
            String str = sc.nextLine();
            for(int j=0; j<M; j++){
                ice[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0; //결과값 저장(아이스 개수)

        for(int i=0; i<N; i++){ //하나씩 탐색
            for(int j=0; j<M; j++){
                if(dfs(i, j)) result+=1;
            }
        }

        System.out.println(result);

    }
}
