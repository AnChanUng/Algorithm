import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : scoville) pq.add(x);
        
        while(pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            count++;
        }
        if(pq.peek() < K) return -1;
        
        return count;
    }
}