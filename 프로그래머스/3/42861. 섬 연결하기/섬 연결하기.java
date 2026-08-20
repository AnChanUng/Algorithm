import java.util.*;

/*
    [한줄 설명] 모든 섬을 최소 비용으로 연결하는 최소 신장 트리(MST) 비용 합 구하기
    [알고리즘] 프림(Prim), 우선순위큐 기반
    [자료구조] 인접리스트 List<Edge>[], PriorityQueue<Edge>, boolean[] vis
    [엣지 케이스] n=1이면 0 리턴, 무방향이라 같은 간선이 두 번 들어가므로 vis로 중복 차단
*/
class Solution {
    static List<Edge>[] graph;
    static boolean[] vis;
    static int n;                                         // prim의 종료 조건에서 필요해 필드로 보관

    public int solution(int n, int[][] costs) {
        this.n = n;                                       // 파라미터를 필드에 복사해 다른 메서드에서 접근
        graph = new List[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();                 // 각 칸 초기화 안 하면 add 시 NPE
        }

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            graph[a].add(new Edge(b, cost));              // 무방향이라 양쪽 모두 등록
            graph[b].add(new Edge(a, cost));
        }

        return prim(0);                                   // MST는 시작점이 어디든 총합 동일
    }

    static int prim(int start) {
        int total = 0;
        int visited = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();   // Edge가 Comparable 구현체라 비교자 생략 가능
        pq.offer(new Edge(start, 0));                     // 시작 섬을 비용 0으로 투입

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();                         // 덩어리 밖으로 나가는 간선 중 최소 비용

            if (vis[cur.node]) continue;                  // 이미 편입된 섬이면 사이클이므로 폐기
            vis[cur.node] = true;                         // poll 시점 방문 처리가 프림의 핵심
            visited++;
            total += cur.cost;

            if (visited == n) break;                      // 섬 n개 전부 연결 완료

            for (Edge next : graph[cur.node]) {
                if (!vis[next.node]) {                    // 미방문 섬으로 향하는 간선만 후보 등록
                    pq.offer(next);
                }
            }
        }

        return total;
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;                    // 비용 오름차순 정렬
        }

        @Override
        public String toString() {
            return node + " " + cost;
        }
    }
}