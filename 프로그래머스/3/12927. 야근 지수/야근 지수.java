import java.util.*;
/*
    야근 피로도의 최소값

    알고리즘: 시뮬레이션, 우선순위큐
    
    - 우선순위큐 내림차순
    - while(n이 0이 될때까지)
     - 우선순위큐 맨 앞에꺼를 1만큼 뺴줌
     
    남은 수에서 각 제곱의 합 출력
*/
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++) 
            pq.offer(works[i]);
        
        while(n --> 0) {
            int cur = pq.poll();
            if(cur == 0) return answer;
            cur--;
            pq.offer(cur);
        }
        
        while(!pq.isEmpty()) { 
            answer += Math.pow(pq.poll(), 2);
        }
            
        return answer;
    }
}