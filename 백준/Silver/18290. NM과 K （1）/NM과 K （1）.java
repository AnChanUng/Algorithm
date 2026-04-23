import java.util.*;
import java.io.*;
/* 
    격자판에서 k개의 칸을 선택해서 칸의 들어있는 수들의 합의 최대값 구하기
    - 칸은 인접하면 안됨

    알고리즘: 백트래킹 (dfs)
    자료구조: 배열

    dfs 인접하지 않는 수들의 합을 depth를 k만큼 더했을 때, 최대값
*/
public class Main {
    static int n, m, k;
    static int[][] graph;
    static int[][] vis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        vis = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0, 0, 0);
        System.out.println(maxSum);
    }
    static void dfs(int sr, int sc, int sum, int depth) {
        if(depth == k) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for(int i=sr; i<n; i++) {
            int startJ;
            if(i == sr) startJ = sc;
            else startJ = 0;
            for(int j=startJ; j<m; j++) {
                if(vis[i][j] == 0) {
                    for(int dir=0; dir<4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        vis[nx][ny]++;
                    }
                   
                    dfs(i, j+1, sum + graph[i][j], depth+1);
                    
                    for(int dir=0; dir<4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        vis[nx][ny]--;
                    }
                }
            }
        }
    }
}