import java.util.*;
/*
    알고리즘: 파라메트릭 서치
    탐색 대상: 모든 사람이 심사를 받는 시간 T
    범위: left = ? 
         right = ?
    
    판정: n분 동안 처리 인원 = Σ (T / time[i]) 가 n 이상인가?
    
    - 가능하면 → 답 후보로 저장, 더 짧은 시간 탐색
    - 불가능하면 → 더 긴 시간 탐색
*/
class Solution {
    static int[] time;
    public long solution(int n, int[] times) {
        long answer = 0;
        time = times;                           
        
        long maxTime = 0;
        for (int i = 0; i < time.length; i++) {
            maxTime = Math.max(maxTime, time[i]);
        }
        
        long left = 1;               
        long right = maxTime * n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            
            if(isValid(mid, n)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private static boolean isValid(long t, int n) {
        long count = 0;
        
        for(int i=0; i<time.length; i++) {
            count += t / time[i];
            if(count >= n) { 
                return true;
            }
        }
        
        return false;
    }
}