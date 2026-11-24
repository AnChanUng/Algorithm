import java.util.*;
import java.lang.*;
import java.io.*;
/*
    며칠이 지나야 토마도가 다익는지 최소 일수

    알고리즘: BFS

    값이 1인 토마토의 4방향중 0인것은 1로 변경함
    0이 하나도 없으면 종료
*/
class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static int m, n;
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        int ans = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {

                if(board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                ans = Math.max(ans, board[i][j]);
            }
        }

        System.out.println(ans - 1);
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] != 0) continue;

                board[nx][ny] = board[cur[0]][cur[1]] + 1;

                q.offer(new int[]{nx, ny});
            }
        }
    }
}