package Implementation;

import java.util.Scanner;

public class ex4_1 {  //좌표를 입력하고 움직일 수 있는 경우의 수 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] move = {{-1,2}, {-1,-2}, {1,2}, {1,-2}, {-2,-1}, {-2, 1}, {2,1}, {2,-1}}; //이동할 수 있는 방향

        char[] input = sc.next().toCharArray(); //char 배열로 입력
        int[] xy = {input[0]-'a'+1, input[1]-'0'}; //x좌표, y좌표 모두 숫자로 표현

        int count=0; //개수 측정

        for(int i=0; i<move.length; i++){ //move의 개수만큼 반복
            int next_x = xy[0] + move[i][0]; //다음 x좌표 예상
            int next_y = xy[1] + move[i][1]; //다음 y좌표 예상

            //움직인 후에도 좌표평면 위에 위치한다면 count++
            if(next_x>=1 && next_x<=8 && next_y>=1 && next_y<=8) count++;
        }

        System.out.println(count);
    }
}
