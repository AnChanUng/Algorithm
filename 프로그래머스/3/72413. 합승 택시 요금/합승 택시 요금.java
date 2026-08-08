import java.util.*;
/*
    가중치 최단 거리 구하기
        
    알고리즘: 다익스트라, 우선순위큐, 인접리스트
    
    n: 지점의 개수 (정점의 개수)
    s: 출발지점
    a: A의 도착지점
    b: B의 도착지점
    fares: 택시요금
    fares[0]과 fares[1]의 가중치는 fares[2]
    
    1. fares를 통해 양방향 인접리스트 가중치 그래프를 만듬
    2. bfs로 돌림
    2.1 A와 B가 같이 이동하는 경우
    2.2 A와 B가 따로 이동하는 경우
*/
class Solution {
    static List<Node>[] list;
    static int N;
    static int minNum;
    static class Node implements Comparable<Node> {
        int v;
        int cost;
        
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        minNum = Integer.MAX_VALUE; // 가중치 최소합
        
        list = new List[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
            
        for(int i=0; i<fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }
        
        int[] distS = dijkstra(s);
        int[] distA = dijkstra(a);
        int[] distB = dijkstra(b);
        
        for(int k=1; k<=n; k++) {
            if(minNum > distS[k] + distA[k] + distB[k]) {
                minNum = distS[k] + distA[k] + distB[k];
            }
        }
        
        return minNum;
    }
    static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            // 비용이 가장 작은 노드를 꺼낸다
            Node cur = pq.poll();
            
            // 이미 더 짧은 경로를 찾아둔 상태면 건너뛴다
            if(cur.cost > dist[cur.v]) continue;
            
            // 인접 노드를 돌면서 "현재까지 비용 + 간선 비용"이 기존 dist보다 작으면 갱신하고 힙에 넣는다
            for(Node next : list[cur.v]) {
                int nCost = cur.cost + next.cost;
                if(nCost < dist[next.v]) {
                    dist[next.v] = nCost;
                    pq.add(new Node(next.v, nCost));
                }
            }
        }
        return dist;
    }
}