package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex6_2 {
    static class Student{
        String name;
        int score;

        Student(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //학생의 수
        Student[] student = new Student[N];
        for(int i=0; i<N; i++){
            student[i] = new Student(sc.next(), sc.nextInt());
        }

        Arrays.sort(student, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//          성적이 같은 경우 이름 순으로 나열하고 싶을 때
//          이것을 쓰지 않으면 입력 순으로 나열됨
//                if(o1.score == o2.score){
//                    return o1.name.compareTo(o2.name);
//                }
                return o1.score - o2.score;
            }
        });

        for(int i=0; i<N; i++){
            System.out.print(student[i].name + " ");
        }
    }
}
