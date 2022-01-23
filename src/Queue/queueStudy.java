package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class queueStudy {
    public static void main(String[] args) {

        //큐 선언
        Queue<Integer> queue1 = new LinkedList<>(); //int형 큐 선언
        Queue<String> queue2 = new LinkedList<>(); //String형 큐 선언

        //큐 값 추가
        queue1.add(1);
        queue1.add(2);
        queue1.offer(3);

        /**
         * add 와 offer 모두 삽입에 성공하면 true, 실패하면 false 반환
         * offer 은 다른 예외사항 없이 false 를 반환하지만,
         * add 는 큐에 여유공간이 없으면 IllegalStateException 발생
         */

        //큐 값 삭제
        queue1.poll();   //큐에 첫번째 값을 반환하고 제거, 비어있다면 null반환
        queue1.remove(); //큐에 첫번째 값을 반환하고 제거
        queue1.clear();  //큐 초기화

        //가장 먼저 들어간 값 출력
        queue1.peek();   //큐의 첫번째 값 참조
    }
}

