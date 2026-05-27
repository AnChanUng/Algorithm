import java.util.*;
/*
    S -> L -> E로 이동하는 최소 시간
    
    알고리즘: bfs
*/
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] dist;
    static String[] map;
    static int n, m;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        dist = new int[n][m];
        map = maps;

        int sx = 0;
        int sy = 0;
        int lx = 0;
        int ly = 0;
        int ex = 0;
        int ey = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char ch = maps[i].charAt(j);
                if(ch == 'S') { sx = i; sy = j; }
                if(ch == 'L') { lx = i; ly = j; }
                if(ch == 'E') { ex = i; ey = j; }
            }
        }    
        for(int[] row : dist) Arrays.fill(row, -1);
        int a = bfs(sx, sy, lx, ly);

        for(int[] row : dist) Arrays.fill(row, -1);
        int b = bfs(lx, ly, ex, ey);

        if(a == -1 || b == -1) return -1;
        return a + b;
    }
    static int bfs(int x, int y, int ex, int ey) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        dist[x][y] = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == ex && cur[1] == ey) return dist[ex][ey];
            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] == -1 && map[nx].charAt(ny) != 'X') {
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}