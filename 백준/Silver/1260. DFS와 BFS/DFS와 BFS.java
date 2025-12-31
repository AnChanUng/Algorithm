import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static boolean[] vis;
    static int n, m, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수
        v = Integer.parseInt(st.nextToken());

        graph = new int[1002][1002];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        vis = new boolean[1002];
        dfs(v);
        sb.append("\n");
        Arrays.fill(vis, false);
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int start) {
        vis[start] = true;
        sb.append(start).append(" ");
        for(int i=1; i<=n; i++) {
            if(graph[start][i] == 1 && !vis[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        vis[start] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int i=1; i<=n; i++) {
                if(graph[cur][i] == 1 && !vis[i]) {
                    vis[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}