import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int[][] graph;
    static boolean[][] vis;
    static int n;
    static int r1, c1, r2, c2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        vis = new boolean[n][n];

        bfs(r1, c1);
    }
    static void bfs(int x, int y) {        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        vis[x][y] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            //System.out.println(cur[0] + " " + cur[1]);
            for(int dir=0; dir<6; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(!vis[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    vis[nx][ny] = true;
                    graph[nx][ny] = graph[cur[0]][cur[1]] + 1;
                }
                if(nx == r2 && ny == c2) {
                    System.out.println(graph[nx][ny]);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}