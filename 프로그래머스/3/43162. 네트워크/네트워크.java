class Solution {
    static int[][] arr;
    static boolean[] vis;
    static int size;
    static int cnt;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        arr = computers;
        size = n;
        
        vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                cnt = 0;
                vis[i] = true;
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int node) {
        for(int i=0; i<size; i++) {
            if(!vis[i] && arr[node][i] == 1) {
                vis[i] = true;
                dfs(i);
            }
        }
    }
}