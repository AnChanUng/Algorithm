import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int r, c;
    static char[][] arr;
    static boolean[] vis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int maxCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        arr = new char[r][c];
        vis = new boolean[26];
        maxCnt = 0;
        for(int i=0; i<r; i++) {
            String s = br.readLine();
            for(int j=0; j<c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        vis[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(maxCnt);
    }
    static void dfs(int x, int y, int cnt) {
        maxCnt = Math.max(maxCnt, cnt);
        
        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

            char next = arr[nx][ny];
            
            if(!vis[next - 'A']) {
                vis[next - 'A'] = true;
                dfs(nx, ny, cnt + 1);
                vis[next - 'A'] = false;
            }
        }
    }
}