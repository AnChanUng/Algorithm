import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            pq.add(x);
        }
        int total = 0;
        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int result = first + second;
            total += result;
            pq.add(first + second);
        }
        
        System.out.println(total);
    }
}