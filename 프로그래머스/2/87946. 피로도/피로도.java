import java.util.*;
/*
    최소피로도 보다 높으면 현재 피로도를 소모해 다음으로 탐색해서 가장 많이 탐색하는 경우 
    탐색 수 구하기

    알고리즘: dfs
    
    - dfs(int depth, int 현재피로도)
     - 더이상 이동할 수 없으면 return;
     - 현재 depth가 최대 depth 보다 크면 갱신
    - 최대 depth 출력
*/
class Solution {
    static int[][] dungeons;
    static boolean[] vis;
    static int maxDepth;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        
        maxDepth = 0;
        vis = new boolean[dungeons.length];
        
        dfs(0, k);
        
        return maxDepth;
    }

    private static void dfs(int depth, int perodo) {
        maxDepth = Math.max(maxDepth, depth);
        
        for(int i=0; i<dungeons.length; i++) {
            if(vis[i]) continue;
            
            int wantPerodo = dungeons[i][0];
            int spendPerodo = dungeons[i][1];
            
            int curPerodo = perodo - spendPerodo; 
            
            if(perodo >= wantPerodo && curPerodo >= 0) {
                vis[i] = true;
                dfs(depth+1, curPerodo);
                vis[i] = false;
            }
        }
    }
}