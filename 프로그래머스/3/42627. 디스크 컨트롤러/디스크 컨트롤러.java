import java.util.*;
class Solution {
    static class Node implements Comparable<Node> {
        int number;
        int requestTime;
        int spendTime;
        
        Node(int number, int requestTime, int spendTime) {
            this.number = number;
            this.requestTime = requestTime;
            this.spendTime = spendTime;
        }
        
        public int compareTo(Node o) {
            if(this.spendTime != o.spendTime) {
                return Integer.compare(this.spendTime, o.spendTime);
            }
            if(this.requestTime != o.requestTime) {
                return Integer.compare(this.requestTime, o.requestTime);
            }
            return Integer.compare(this.number, o.number);
        }
    }
    public int solution(int[][] jobs) { // [요청되는 시점, 작업의 소요시간]
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
      
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        int idx = 0;
        int total = 0; // 반환 시간
        int done = 0; // 하드디스크 작업 완료 건수
        int time = 0; // 작업 종료 시각
        while(done < jobs.length) {
            while(idx < jobs.length && time >= jobs[idx][0]) {
                pq.add(new Node(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            if(!pq.isEmpty()) {
                Node n = pq.poll();
                time += n.spendTime;
                total += time - n.requestTime;
                done++;
                System.out.println("requet:" + n.requestTime + " time: " + time + " total: " + total);
            } else {
                time = jobs[idx][0];
            }
        }
        return total / jobs.length;
    }
}