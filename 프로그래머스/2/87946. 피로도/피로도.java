import java.util.*;
class Solution {
    static boolean[] vis;
    static int maxNum;
    public int solution(int k, int[][] dungeons) {
        vis = new boolean[dungeons.length];
        dfs(dungeons, k, 0, 0);
        return maxNum;
    }
    
    static void dfs(int[][] dungeons, int sum, int cnt, int depth) {
        maxNum = Math.max(maxNum, cnt);
        for(int i=0; i<dungeons.length; i++) {
            if(!vis[i] && dungeons[i][0] <= sum) {
                vis[i] = true;
                dfs(dungeons, sum-dungeons[i][1], cnt+1, depth+1);
                vis[i] = false;
            }
        }
    }
}