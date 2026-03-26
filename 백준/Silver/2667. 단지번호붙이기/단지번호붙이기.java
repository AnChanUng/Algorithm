import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int[][] arr;
    static boolean[][] vis;
    static ArrayList<Integer> list;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        vis = new boolean[n][n];
        list = new ArrayList<>();
            
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!vis[i][j] && arr[i][j] == '1') {
                    cnt = 0;
                    vis[i][j] = true;
                    cnt++;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int x : list) {
            System.out.println(x);
        }
    }
    static void dfs(int x, int y) {
        for(int dir=0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(!vis[nx][ny] && arr[nx][ny] == '1') { 
                cnt++;
                vis[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}