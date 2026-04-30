import java.util.*;
/*
    [작업의 번호, 작업의 요청 시각, 작업의 소요시간]
    
    자료구조: PriorityQueue
    
    디스크 컨트롤러 우선순위
    1. 작업의 소요시간이 짧은 것
    2. 작업의 요청 시각이 빠른 것
    3. 작업의 번호가 작은 것
    
    우선순위 큐에 작업의 소요시간이 짧은것, 요청시각이 빠른 것, 작업의 번호가 작은 것 순으로 실행
*/
class Solution {
    public int solution(int[][] jobs) { // [작업이 요청되는 시점, 소요시간]
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int total = 0;
        int curTime = 0;
        int idx = 0;
        int cnt = 0;
        while(cnt < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= curTime) {
                pq.add(jobs[idx]);
                idx++;
            }
            if(!pq.isEmpty()) {
                int[] cur = pq.poll();
                curTime += cur[1];
                total += curTime - cur[0];
                cnt++;
            } else {
                curTime = jobs[idx][0];
            }
        }
        return total / jobs.length;
    }
}