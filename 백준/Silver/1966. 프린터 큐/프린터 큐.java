import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
    1.1 test_case 입력 받기
    1.2 n, m 입력 받기
    1.3 n개 만큼 중요도 입력 받기
    2.  큐에서 m번째가 나올 때 까지
    2.1 큐에서 중요도가 제일 높은게 맨 앞에 있으면 출력
    2.2 아닐 경우 맨 뒤로 보냄
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        for(int i=0; i<test_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int j=0; j<n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                q.offer(new int[] {j, priority});
                pq.offer(priority);
            }

            int cnt = 0;
            while(true) {
                int[] cur = q.poll();
                int idx = cur[0];
                int val = cur[1];

                if(val == pq.peek()) {
                    pq.poll();
                    cnt++;
                    if(idx == m) {
                        System.out.println(cnt);
                        break;
                    }
                } else {
                    q.offer(cur);
                }
            }
        }
    }
}