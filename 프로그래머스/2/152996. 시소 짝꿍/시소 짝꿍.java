import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long cnt = 0;
        
        Arrays.sort(weights);
        
        int n = weights.length;
    
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(weights[i] == weights[j] || 
                  weights[i] * 2 == weights[j] ||
                   weights[i] * 3 == weights[j] * 2 ||
                   weights[i] * 4 == weights[j] * 3
                  ) { 
                    cnt++; 
                }
            }
        }
        return cnt;
    }
}