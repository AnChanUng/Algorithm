import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        for(int i=0; i<book_time.length; i++) {
            bookTime[i][0] = toMinute(book_time[i][0]);
            bookTime[i][1] = toMinute(book_time[i][1]) + 10;
        }
        
        Arrays.sort(bookTime, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int answer = 0;
        for(int i=0; i<bookTime.length; i++) {
            while(!pq.isEmpty() && pq.peek() <= bookTime[i][0]) {
                pq.poll();
            }
            pq.offer(bookTime[i][1]);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    private static int toMinute(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}