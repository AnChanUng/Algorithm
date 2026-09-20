import java.util.*;
/*
    각 sources에 있는 지역별로 desination까지 걸리는 길이 구하기
    
    알고리즘: bfs (인접리스트)
    
    1. 인접리스트로 roads를 연결한다
    2. sources를 하나씩 순회하며 bfs 돌려서 목적지에 도착하는지 확인한다.
    3. 배열 출력
*/
class Solution {
    static List<Integer>[] graph;
    static int[] dist;
    static int[] res;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new List[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        bfs(destination);
        
        res = new int[sources.length];
        for(int i=0; i<sources.length; i++) {
            res[i] = dist[sources[i]];
        }
        
        return res;
    }
    
    private static void bfs(int node) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        dist[node] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph[cur]) {
                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}