import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }

        // 모든음식이 k이상일 때
        while(pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + (b * 2));
            cnt++;
        }
        for(int x : pq) {
            if(x < K) {
                return -1;
            }
        }
        
        return cnt;
    }
}