package practice;

import java.util.Scanner;

public class p4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] grid = new int[N][N];
        sc.nextLine();//버퍼지우기

        char[] plan = new char[100]; //1<=이동횟수<=100
        String str = sc.nextLine();
        for(int i=0; i<str.length(); i++){
            plan[i] = str.charAt(i);
        }

        int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //상하좌우 이동 시 좌표변화
        int x=1, y=1; //초기 x,y값

        for(int i=0; i<plan.length; i++){ //plan을 읽고 위치 이동
            if(plan[i] == 'U' && x>1){
                x = x + move[0][0];
                y = y + move[0][1];
            }
            else if(plan[i] == 'D' && x<N){
                x = x + move[1][0];
                y = y + move[1][1];
            }
            else if(plan[i] == 'L' && y>1){
                x = x + move[2][0];
                y = y + move[2][1];
            }
            else if(plan[i] == 'R' && y<N){
                x = x + move[3][0];
                y = y + move[3][1];
            }
        }

        System.out.println(x + " " + y);
    }
}
