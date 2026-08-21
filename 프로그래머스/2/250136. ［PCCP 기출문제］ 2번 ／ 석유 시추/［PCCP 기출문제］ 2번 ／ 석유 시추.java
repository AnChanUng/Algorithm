import java.util.*;
/*
    가장 많은 석유를 뽑을 수 있는 시추관의 위치 찾기
    
    알고리즘: bfs
    
    1. bfs를 통해 그래프에 모든경로의 합을 dist 배열에 저장한다.
    2. 행을 한칸씩 확인하고 그 행의 열을 모두 확인해서 dist에서 저장한다. 
    2.1 dist에 가장 큰 수만 저장한다.
    3. 각 행의 합중에서 가장 큰 것을 출력한다.
    
    세로 n * 가로 m
    0: 빈땅
    1: 석유
*/
class Solution {
    static int[][] land;
    static boolean[][] vis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] colSum;
    static int maxSum;
    static int n = 0;
    static int m = 0;
    static int cnt;
    public int solution(int[][] land) {
        this.land = land;
        n = land.length;
        m = land[0].length;
        maxSum = 0;
        vis = new boolean[n][m];
        colSum = new int[m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && land[i][j] == 1) { 
                    cnt = 0;
                    bfs(i, j); 
                }
            }
        }
    
        for(int i=0; i<m; i++) {
            maxSum = Math.max(colSum[i], maxSum);
        }
        
        return maxSum;
    }
    static void bfs(int x, int y) {
        Deque<int[]> qq = new ArrayDeque<>();
        Deque<int[]> q = new ArrayDeque<>();
        vis[x][y] = true;
        q.offer(new int[]{x, y});
        
        int maxCol = y;
        int minCol = y;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
            maxCol = Math.max(maxCol, cur[1]);
            minCol = Math.min(minCol, cur[1]);
            qq.offer(new int[]{cur[0], cur[1]});
            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(!vis[nx][ny] && land[nx][ny] == 1) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        for(int i=minCol; i<=maxCol; i++) {
            colSum[i] += cnt;
        }
    }
}