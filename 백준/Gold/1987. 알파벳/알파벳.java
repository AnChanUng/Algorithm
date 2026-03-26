import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] arr;
    static boolean[] alpha;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int maxCnt;
    static int cnt;
    static int r, c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];   
        alpha = new boolean[26]; // 알파벳 지났는지 아닌지 

        for(int i=0; i<r; i++) {
            String str = br.readLine();
            for(int j=0; j<c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        maxCnt = 0;
        cnt = 1;
        dfs(0, 0);
        System.out.print(maxCnt);
    }
    static void dfs(int x, int y) {
        //System.out.println("x: " + x + " y: "  + y + " cnt: " + cnt + " maxCnt: " + maxCnt);
        maxCnt = Math.max(maxCnt, cnt);
        alpha[arr[x][y]-'A'] = true;
        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if(!alpha[arr[nx][ny]-'A']) {
                cnt++;
                alpha[arr[nx][ny]-'A'] = true;
                dfs(nx, ny);
                alpha[arr[nx][ny]-'A'] = false;
                cnt--;
            } 
        }
    }
}