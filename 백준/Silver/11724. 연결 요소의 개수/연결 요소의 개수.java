import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] vis;
    static int n, m;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        vis = new boolean[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = 1;
        }
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(!vis[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    static void dfs(int start) {
        vis[start] = true;
        for(int i=1; i<=n; i++) {
            if(graph[start][i] == 1 && !vis[i]) {
                dfs(i);
            }
        }
    }
}