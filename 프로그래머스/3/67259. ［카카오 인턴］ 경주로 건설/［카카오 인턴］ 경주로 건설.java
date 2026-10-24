import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] Board;
    static int[][][] dist;
    static int n, m;
    static class Node implements Comparable<Node> {
        int x, y, d, cost;
        
        Node(int x, int y, int d, int cost) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public int solution(int[][] board) {
        n = board.length;
        m = board[0].length;
        
        Board = board;
        dijkstra(0, 0);

        int minNum = Integer.MAX_VALUE;
        for(int i=0; i<4; i++) {
            minNum = Math.min(dist[n-1][m-1][i], minNum);
        }
        
        return minNum;
    }
    
    private static void dijkstra(int x, int y) {
        dist = new int[n][m][4];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, y, -1, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.x == n-1 && cur.y == m-1) break;
            for(int dir=0; dir<4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(Board[nx][ny] == 1) continue;

                int nextCost = 100;
                
                if(cur.d != -1 && cur.d != dir) {
                    nextCost += 500;
                }
                
                int totalCost = cur.cost + nextCost;
                if(totalCost < dist[nx][ny][dir]) {
                    dist[nx][ny][dir] = totalCost;
                    pq.offer(new Node(nx, ny, dir, totalCost));
                }
            }
        }
    }
}