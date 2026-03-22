import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static int[][] arr;
    static boolean[] vis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        vis = new boolean[n];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[m];
        for(int i=0; i<m; i++) {
            plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        dfs(plan[0]);

        boolean flag = true;
        for(int i=0; i<m; i++) {
            if(!vis[plan[i]]) {
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static void dfs(int x) {
        vis[x] = true;
        for(int i=0; i<n; i++) {
            if(arr[x][i] == 1 && !vis[i]) {
                dfs(i);
            }
        }
    }
}