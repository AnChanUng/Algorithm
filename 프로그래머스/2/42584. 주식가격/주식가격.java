import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = answer = new int[prices.length];
        
        int cnt = 1;
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}