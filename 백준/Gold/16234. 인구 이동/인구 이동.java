import java.util.*;
import java.lang.*;
import java.io.*;
/*
    1. 입력 받기
    2. 인구 이동
    2.1 L <= 인구 차이 <= R 국경선 오픈
    2.2 인접한 칸만을 이용해 연합국으로 이동
    2.3 연합 인구수 : 각 칸의 인구수 합 / 전체 칸의 개수 
    2.4 연합 해체, 국경선 닫기
*/
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

        int count = 0;
        
        while(true) {
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
            count++;
        }
        System.out.println(count);
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        q.offer(new int[]{x, y});
        vis[x][y] = true;
        union.add(new int[]{x, y});

        int sum = graph[x][y];

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int dir=0; dir<4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(vis[nx][ny]) continue;

                int diff = Math.abs(graph[cx][cy] - graph[nx][ny]);

                if(l <= diff && diff <= r) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    sum += graph[nx][ny];
                }
            }
        }
        if(union.size() == 1) return false;

        int avg = sum / union.size();

        for(int[] country : union) {
            graph[country[0]][country[1]] = avg;
        }
        
        return true;
    }
}