import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];

        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        for(int i=0; i<info.length; i++) {
            int[] next = new int[m];
            Arrays.fill(next, Integer.MAX_VALUE);

            for(int b=0; b<m; b++) {
                if(dp[b] == Integer.MAX_VALUE) continue;

                // A가 훔치는 경우
                int aTrace = dp[b] + info[i][0];

                if(aTrace < n) {
                    next[b] = Math.min(next[b], aTrace);
                }

                // B가 훔치는 경우
                int bTrace = b + info[i][1];

                if(bTrace < m) {
                    next[bTrace] = Math.min(next[bTrace], dp[b]);
                }
            }

            dp = next;
        }

        int answer = Integer.MAX_VALUE;

        for(int b=0; b<m; b++) {
            answer = Math.min(answer, dp[b]);
        }

        if(answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
    }
}