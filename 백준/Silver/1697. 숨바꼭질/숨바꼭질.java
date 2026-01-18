import java.io.*;
import java.util.*;

public class Main {
    static int[] dist;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        Arrays.fill(dist, -1);
        bfs(n);
        System.out.println(dist[k]);
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[n] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == k) { break; }
            for(int nx : new int[]{cur - 1, cur + 1, cur * 2}) {
                if(nx < 0 || nx > 100000) continue;
                if(dist[nx] == -1) {
                    q.add(nx);
                    dist[nx] = dist[cur] + 1;
                }
            }
        }
    }
}