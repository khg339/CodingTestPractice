package Implementation;

import java.util.Scanner;

public class ex4_2 {

    public static int turn_left(int d){ //왼쪽으로 회전시켜주는 메서드
        if(d==0) return 3; //북쪽이면 서쪽으로
        else return d-1;   //나머지는 -1해주면 왼쪽으로 회전
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //세로
        int M = sc.nextInt(); //가로

        int x = sc.nextInt(); //캐릭터가 서 있는 세로위치
        int y = sc.nextInt(); //캐릭터가 서 있는 가로위치
        int d = sc.nextInt(); //캐릭터가 서 있는 방향

        int[][] map = new int[N][M]; //지도
        int[][] visit = new int[N][M]; //가본 곳 처리
        for(int i=0; i<M; i++){ //입력 및 초기화
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
                visit[i][j] = 0;
            }
        }

        visit[x][y] = 1; //현재 서 있는 곳은 가본 곳 처리

        int[][] move = {{-1,0}, {0,1}, {1,0}, {0,-1}}; //북동남서 순으로 방향 저장
        int result = 1; //방문한 육지 수 저장, 처음엔 무조건 육지
        int turn_time = 0; //같은 자리에서 몇 번 회전하는지 저장

        while(true){ //break; 되는 경우까지 계속 반복
            d = turn_left(d); //왼쪽으로 회전
            int nx = x + move[d][0], ny = y + move[d][1]; //예상 위치

            if(nx<0 || nx>=N || ny<0 || ny>=M) continue; //예상위치가 지도를 벗어나면 다시 반복

            if(map[nx][ny] == 0 && visit[nx][ny] == 0){ //예상위치가 가보지 않은 육지라면
                x = nx; //이동
                y = ny;
                visit[x][y] = 1; //가본 곳 처리
                result++;
                turn_time = 0;
                continue; //다시 반복
            }
            else{ //예상위치가 바다이거나 가본 곳이라면
                turn_time++;
                }

            if(turn_time == 4){ //4번 다 돌아서 제자리로 돌아오면
                nx = x - move[d][0];
                ny = y - move[d][1];

                if(nx<0 || nx>=N || ny<0 || ny>=M) break; //예상위치가 지도를 벗어나면 종료
                if(map[nx][ny] == 0){ //예상위치가 육지라면(가본 곳 포함) 뒤로 이동
                    x = nx;
                    y = ny;
                }
                else break; //예상위치로 더이상 이동할 수 없다면 종료
                turn_time = 0;   //다시 초기화
            }
        }

        System.out.println(result);
    }
}
