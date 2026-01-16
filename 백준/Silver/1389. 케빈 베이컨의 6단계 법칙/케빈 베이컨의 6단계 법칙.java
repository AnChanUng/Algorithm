import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[] vis;
    static int[] dist;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        vis = new boolean[n+1];
        dist = new int[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        int answer = 1;
        int minSum = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            Arrays.fill(vis, false);
            Arrays.fill(dist, 0);
            bfs(i);

            int sum = 0;
            for(int j=1; j<=n; j++) {
                sum += dist[j];
            }
            if(sum < minSum) {
                minSum = sum;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        vis[start] = true;
        q.add(start);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=1; i<=n; i++) {
                if(graph[cur][i] == 1 && !vis[i]) {
                    vis[i] = true;
                    dist[i] = dist[cur] + 1;
                    q.add(i);
                }
            }
        }
    }
}