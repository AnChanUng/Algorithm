import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
    문제
    1. n 입력 받기
    2. 큐에 1 ~ n에 저장
    3. 큐에 1개 남을때 까지 무한루프
    3.1 - 맨 앞에 있는 수 삭제
    3.2 - 맨 앞에 있는 수 맨 뒤로 옮기기
    4. 1개 남은 수 출력
*/
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++) {
            q.offer(i);
        }

        while(q.size() != 1) {
            q.poll();
            int qq = q.peek();
            q.poll();
            q.offer(qq);
        }

        System.out.print(q.peek());
    }
}