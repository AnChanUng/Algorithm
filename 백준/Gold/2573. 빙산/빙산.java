import java.util.*;
import java.lang.*;
import java.io.*;
/*
    4방향으로 0이 저장된 개수만큼 줄어듬
    0보다는 더 줄어들지 않음
    두덩어리이상 빙산이 분리되는 최초의 시간

    알고리즘: bfs, dfs

    while
        dfs로 몇블럭으러 나눠져 있는지 확인
        2개 블럭이상 나눠져있으면 break
        모든 숫자가 0이면 0출력 break 
        
        bfs(int x, int y)
        - 격자탐색해서 0의 개수만큼 현재위치 -1

        개수 카운트++
*/
class Main {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static int[][] graph;
    static boolean[][] bfsVis;
    static boolean[][] checkVis;
    static int n, m, blockCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while(true) {
            blockCnt = 0;
            checkVis = new boolean[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(board[i][j] <= 0) continue;
                    if(checkVis[i][j]) continue;
                    check(i, j, board);
                    blockCnt++;;
                }
            }
            
            if(blockCnt >= 2) break;
            if(blockCnt == 0) {
                cnt = 0;
                break;
            }
            
            graph = new int[n][m];
            bfsVis = new boolean[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(board[i][j] <= 0) continue;
                    if(bfsVis[i][j]) continue;
                    bfs(i, j, graph);
                }
            }
            
            board = graph;
            cnt++;
        }

        System.out.println(cnt);
    }

    private static void check(int x, int y, int[][] graph) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        checkVis[x][y] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(checkVis[nx][ny]) continue;
                if(graph[nx][ny] >= 1) {
                    q.offer(new int[]{nx, ny});
                    checkVis[nx][ny] = true;
                }
            }
        }
    }
    
    private static void bfs(int x, int y, int[][] graph) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        bfsVis[x][y] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int seaCnt = 0;
            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 바다의 개수 확인
                if(board[nx][ny] == 0) {
                    seaCnt++;
                    continue;
                }
                if(bfsVis[nx][ny]) continue;
              
                bfsVis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
            graph[cur[0]][cur[1]] = Math.max(0, board[cur[0]][cur[1]] - seaCnt);
        }    
    }
}