import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, l, r;
    static int[][] graph;
    static boolean[][] vis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while(true){
            vis = new boolean[n][n];
            boolean flag = false;
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!vis[i][j]) {
                        if(bfs(i, j)) {
                            flag = true;
                        }
                    }
                }
            }
            if(!flag) break;
            cnt++;
        }
        System.out.println(cnt);
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> q= new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        
        vis[x][y] = true;
        q.offer(new int[]{x, y});
        list.add(new int[]{x, y});
        
        int sum = graph[x][y];
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (vis[nx][ny]) continue;
                int diff = Math.abs(graph[cur[0]][cur[1]] - graph[nx][ny]);
                if(l <= diff && diff <= r) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                    sum += graph[nx][ny];
                }
            }
        }
        if(list.size() == 1) return false;
        int avg = sum / list.size();
        for(int[] country : list) {
            graph[country[0]][country[1]] = avg;
        }
        
        return true;
    }
}