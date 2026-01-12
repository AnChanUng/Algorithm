import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] vis = new boolean[n][m];
        char[][] graph = new char[n][m];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 'I') {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for(int dir=0; dir<4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if(vis[nx][ny]) continue;
                            if(graph[nx][ny] == 'X') continue;
                            if(graph[nx][ny] == 'P') {
                                cnt++;
                            }
                            q.offer(new int[]{nx, ny});
                            vis[nx][ny] = true;
                        }
                    }
                }
            }
        }
        if(cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }
}