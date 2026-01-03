import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /*
            1. 배열에 자연수 x를 넣는다.
            2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                pq.offer(x);
            }
        }
    }
}