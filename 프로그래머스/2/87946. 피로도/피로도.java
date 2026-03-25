import java.util.*;

class Solution {
    static int maxCnt = 0;
    static boolean[] vis;
    public int solution(int k, int[][] dungeons) {  
        vis = new boolean[dungeons.length];
        dfs(dungeons, k, 0, 0);   
        return maxCnt;
    }
    
    static void dfs(int[][] arr, int sum, int cnt, int depth) {
        //System.out.println("depth: " + depth + " cnt: " + cnt + " sum: " + sum + " vis: " + Arrays.toString(vis));
        maxCnt = Math.max(cnt, maxCnt);
        for(int i=0; i<arr.length; i++) {
            if(!vis[i] && arr[i][0] <= sum) {
                vis[i] = true;
                dfs(arr, sum-arr[i][1], cnt+1, depth+1);
                vis[i] = false;
            }
        }    
    }
}