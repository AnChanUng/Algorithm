import java.util.*;
/*
    디스크 컨트롤러에서 모든 요청 작업의 반환 시간의 평균 구하기

    1. 우선순위큐 초기화
    2. 큐가 비어있지 않을 때
    2.1 소요시간 짧은것, 요청 시각 빠른것, 작업번호 작은 것순으로 정렬
    2.2 작업 수행 (동시에 작업 수행 불가)
    3. 큐가 비어있을 때

    알고리즘: 우선순위큐
*/
class Solution {
    static class Node implements Comparable<Node> {
        int number; // 작업의 번호
        int requestTime; // 작업의 요청 시각
        int spendTime; // 작업의 소요시간
        
        Node(int number, int requestTime, int spendTime) {
            this.number = number;
            this.requestTime = requestTime;
            this.spendTime = spendTime;
        }
        // 소요시간 짧은것, 요청 시각 빠른것, 작업번호 작은 것순으로 정렬
        public int compareTo(Node o) {
            // o.number, o.requestTime, o.spendTime
            // 작업의 번호, 작업의 요청 시각, 작업의 소요시간
            if(this.spendTime != o.spendTime) { // 소요시간이 같으면
                // 요청 시각이 빠른 것 순으로 정렬 (오름차순)
                return Integer.compare(this.spendTime, o.spendTime);
            } 
            if(this.requestTime != o.requestTime) { // 요청시각이 같으면
                // 작업번호 오름차순
                return Integer.compare(this.requestTime, o.requestTime);
            }
            return Integer.compare(this.number, o.number);
        }
    }
    public int solution(int[][] jobs) { // [작업이 요청되는 시점, 작업의 소요시간]
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        // [작업의 번호, 작업의 요청 시각, 작업의 소요시간]
        
        int time = 0;
        int idx = 0;
        int done = 0;
        long total = 0;
        while(done < jobs.length) {
            // A. time 이하로 요청된 작업 전부 pq에 투입
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new Node(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            // B. pq 비었으면 time 점프 / 아니면 하나 꺼내 처리
            if(!pq.isEmpty()) {
                Node n = pq.poll();
                time += n.spendTime;
                total += time - n.requestTime;
                done++;
            } else {
                time = jobs[idx][0];
            }
        }
        
        return (int)(total / jobs.length);
    }
}