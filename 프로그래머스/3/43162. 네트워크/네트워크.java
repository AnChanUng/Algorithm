import java.util.*;
class Solution {
    static boolean[] vis;
    static int cnt;
    public int solution(int n, int[][] computers) {
        cnt = 0;
        vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                dfs(computers, i);
                cnt++;
            }
        }        
        return cnt;
    }
    static void dfs(int[][] computers, int node) {
        vis[node] = true;
        for(int i=0; i<computers.length; i++) {
            if(computers[node][i] == 1 && !vis[i]) {
                dfs(computers, i);
            }
        }
    }
}