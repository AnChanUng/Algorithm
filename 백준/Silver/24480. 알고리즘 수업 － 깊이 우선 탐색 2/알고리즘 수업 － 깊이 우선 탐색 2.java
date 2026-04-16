import java.util.*;
import java.io.*;
/*
  
 */
class Main {
  static int n, m, r;
  static List<Integer>[] graph;
  static boolean[] vis;
  static int[] res;
  static int cnt;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken()); // 정점의 수
    m = Integer.parseInt(st.nextToken()); // 간선의 수
    r = Integer.parseInt(st.nextToken()); // 시작 정점

    graph = new ArrayList[n+1];
    vis = new boolean[n+1];
    for(int i=1; i<=n; i++) {
      graph[i] = new ArrayList<>();
    }

    for(int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u].add(v);
      graph[v].add(u);
    }

    for(int i=1; i<=n; i++) {
      Collections.sort(graph[i], Collections.reverseOrder());
    }

    cnt = 1;
    res = new int[n+1];
    dfs(r);
    for(int i=1; i<=n; i++) {
      System.out.println(res[i]);
    }
  }
  static void dfs(int node) {
    vis[node] = true;
    res[node] = cnt++;
    for(int next : graph[node]) {
      if(!vis[next]) {
        dfs(next);
      }
    }
  }
}