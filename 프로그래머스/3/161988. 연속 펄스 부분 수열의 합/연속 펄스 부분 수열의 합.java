import java.util.*;
/*  펄스 부분 수열
    [1, -1, 1] 
    [-1, 1, 1]
    
    연속되는 숫자에 펄스 부분 수열을 곱하고
    그 배열의 합이 가장 큰 것 구하기
    
    // nlogn이기 때문에 투포인터, 이분탐색, 슬라이딩윈도우, dp, 그리디

    알고리즘: 슬라이딩 윈도우
    
    1개 선택 ~ sequence.length개 선택
    
    1. 연속되는 부분수열에 펄스 순열을 곱한다
    2. 부분 수열의 합이 최대합보다 크면 갱신
    3. 최대합 출력
*/
class Solution {
    public long solution(int[] sequence) {
        long maxSum = Long.MIN_VALUE;
        long plusSum = 0;                                
        long minPrefix = 0;                              
        long maxPrefix = 0;                                        
        for(int right=0; right<sequence.length; right++) {
            long pulse = sequence[right] * (right % 2 == 0 ? 1L : -1L);
            plusSum += pulse;
            
            maxSum = Math.max(maxSum, plusSum - minPrefix);
            maxSum = Math.max(maxSum, maxPrefix - plusSum);
            minPrefix = Math.min(minPrefix, plusSum);
            maxPrefix = Math.max(maxPrefix, plusSum);
        }
        
        return maxSum;
    }
}