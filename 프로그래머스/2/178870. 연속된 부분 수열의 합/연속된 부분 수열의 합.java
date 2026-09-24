import java.util.*;
/*
    연속된 수의 합이 k중에 가장 짧은 것
    
    알고리즘: 슬라이딩 윈도우
    
    sequence 배열 순회
    1. sum += sequence[i]를 더함
    2. sum이 k보다 크면 
    2.1 left++, sum -= sequence[i];
    3. sum == k이면
    3.1 left++
    3.2 left, right 인덱스 저장
*/
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while(sum > k) {
                sum -= sequence[left];
                left++;
            }
        
            if(sum == k) {
                int len = right - left;
                if(len < minLen) {
                    answer[0] = left;
                    answer[1] = right;
                    minLen = len;
                }
            }
        }
        
        return answer;
    }
}