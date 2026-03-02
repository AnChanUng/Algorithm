import java.util.*;
import java.lang.*;
import java.io.*;
/*
    1번 -> n번까지 가는 경로 중 가중치 합 최소값
    다익스트라 = 인접리스트 + 우선순위 큐
*/
class Main {
    static int n, m;
    static ArrayList<int[]>[] graph;
    static long[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 헛간 개수
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        dijkstra(1);

        System.out.println(dist[n]);
    }

    static void dijkstra(int start) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[1], b[1])
        );

        dist[start] = 0;
        pq.add(new long[]{start, 0});

        while(!pq.isEmpty()) {
            long[] cur = pq.poll();
            int now = (int)cur[0];
            long cost = cur[1];

            if(cost > dist[now]) continue;

            for(int[] next : graph[now]) {
                int nextNode = next[0];
                int nextCost = next[1];

                if(dist[nextNode] > cost + nextCost) {
                    dist[nextNode] = cost + nextCost;
                    pq.add(new long[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}