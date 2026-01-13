import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph;
    static boolean[][] vis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        vis = new boolean[n][m];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        int x = 0;
        int y = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }
        cnt = 0;
        bfs(x, y);
        if(cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        vis[a][b] = true;
        q.add(new int[] {a, b});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(vis[nx][ny]) continue;
                if(graph[nx][ny] == 'X') continue;
                if(graph[nx][ny] == 'P') {
                    cnt++;
                }
                vis[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }
        }
    }
}