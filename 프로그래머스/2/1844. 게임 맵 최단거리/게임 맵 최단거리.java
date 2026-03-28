import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] dist; 
    static int n, m;
    public int solution(int[][] maps) {      
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        bfs(maps, 0, 0);
        
        int answer = dist[n-1][m-1];
        return answer;
    }
    static void bfs(int[][] maps, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        dist[x][y] = 1;
        q.add(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] == -1 && maps[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
}