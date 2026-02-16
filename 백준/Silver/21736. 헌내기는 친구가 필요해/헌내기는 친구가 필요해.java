import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static char[][] graph;
    static boolean[][] vis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
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
        
        bfs(x, y);
        if(cnt == 0) {
            System.out.print("TT");
        } else {
            System.out.print(cnt);
        }
    }
    
    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        vis[a][b] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(!vis[nx][ny] && graph[nx][ny] == 'O' || graph[nx][ny] == 'P') {
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    if(graph[nx][ny] == 'P') {
                        cnt++;
                        graph[nx][ny] = 'O';
                    }
                }
            }
        }
    }
}