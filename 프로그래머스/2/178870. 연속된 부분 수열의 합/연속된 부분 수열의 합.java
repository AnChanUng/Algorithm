import java.util.*;
/* 투포인터 누적합 */
class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int sum = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;
        int bestEnd = 0;
        for(int right=0; right<sequence.length; right++) {
            sum += sequence[right];
            while(sum > k) {
                sum -= sequence[left];
                left++;
            }
            if(sum == k) {
                int len = right - left + 1;
                if(len < bestLen) {
                    bestLen = len;
                    bestStart = left;
                    bestEnd = right;
                }
            }
        }
        return new int[]{bestStart, bestEnd};
    }
}