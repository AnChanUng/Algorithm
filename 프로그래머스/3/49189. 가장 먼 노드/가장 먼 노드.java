import java.util.*;
/*
    최단경로로 이동했을 때 간선의 개수가 가장 많은 노드
    
    알고리즘: 그래프BFS, 인접리스트
    
    1. 각 그래프를 양방향 인접리스트 연결
    2. 1번노드에서 가장 depth가 긴 것 배열에 저장
*/
class Solution {
    static List<Integer>[] list;
    static boolean[] vis;
    static int[] order;
    public int solution(int n, int[][] edge) {     
        list = new List[n+1];
        
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        bfs(1, n); // 1에서 출발 했을 때, 가장 먼 노드만 출력
        
        //System.out.println(Arrays.toString(order));
        
        Arrays.sort(order);
        
        int cnt = 1;
        for(int i=order.length-1; i>0; i--) {
            if(order[i] == order[i-1]) {
                cnt++;
            } else {
                break;
            }
        }
        
        return cnt;
    }
    static void bfs(int start, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        vis = new boolean[n+1];
        order = new int[n+1];
        
        q.offer(start);
        vis[start] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : list[cur]) {
                if(!vis[next]) {
                    q.offer(next);
                    order[next] = order[cur] + 1;
                    vis[next] = true;
                }
            }
        }
    }
}