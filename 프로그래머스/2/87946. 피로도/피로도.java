import java.util.*;
/* 순열 백트래킹 dfs */
class Solution {
    static boolean[] vis;
    static int maxCnt;
    public int solution(int k, int[][] dungeons) {
        vis = new boolean[dungeons.length];
        maxCnt = 0;
        
        dfs(dungeons, k, 0);
        
        return maxCnt;
    }
    
    static void dfs(int[][] dungeons, int k, int depth) {
        int cnt = 0;
        for(int i=0; i<vis.length; i++) {
            if(vis[i]) {
                cnt++;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!vis[i] && k >= dungeons[i][0]) {
                vis[i] = true;
                dfs(dungeons, k - dungeons[i][1], depth+1);
                vis[i] = false;
            }
        }
    }
}