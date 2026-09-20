import java.util.*;
/*
    10분만에 방을 줄 수 없으면 새로운 룸 생성
    룸의 개수
*/
class Solution {
    public int solution(String[][] book_time) {
        int room = 0;
        
        // 각 문자를 정수로 변경하고 배열에 저장
        int[][] bookTime = new int[book_time.length][2];
        for(int i=0; i<book_time.length; i++) {
            String[] a = book_time[i][0].split(":");
            String[] b = book_time[i][1].split(":");
            
            bookTime[i][0] = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
            bookTime[i][1] = Integer.parseInt(b[0]) * 60 + Integer.parseInt(b[1]);
        }
        
        Arrays.sort(bookTime, (a, b) -> Integer.compare(a[0], b[0]));
        
        System.out.println(Arrays.deepToString(bookTime));
        
        int idx = 0;
        int curTime = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // bookTime 순회
        for(int i=0; i<bookTime.length; i++) {
            // 처음이면 방을 생성
            // pq에 퇴실시간 저장
            if(i == 0) {
                pq.offer(bookTime[i][1]);
                continue;
            }

            // 입실시간이 pq에 있는 퇴실시간+10보다 크면
            // 방생성
            // 현재 pq에 퇴실시간 저장
            int cur = pq.poll();
            if(bookTime[i][0] < cur + 10) {
                pq.offer(bookTime[i][1]);
                pq.offer(cur);
            } 
            
            // 입실시간이 pq에 있는 퇴실시간+10보다 작거나 같으면
            // 현재 pq에 있는걸 뺴주고 퇴실시간 저장
            else {
                pq.offer(bookTime[i][1]);    
            }
        }
        
        return pq.size();
    }
}