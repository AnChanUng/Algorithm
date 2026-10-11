import java.util.*;
import java.lang.*;
import java.io.*;
/*
    시작점 -> 도착점 최단거리 이동

    알고리즘: 다익스트라
*/
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static int[][] dist;
    static int n;

    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
            
        for(int tc=1; tc<=t; tc++) {
            n = Integer.parseInt(br.readLine());

            board = new int[n][n];
            
            for(int i=0; i<n; i++) {
                String str = br.readLine().trim();
                for(int j=0; j<n; j++) {
                    board[i][j] = str.charAt(j) - '0';    
                }
            }

            bfs(0, 0);
            
            sb.append("#").append(tc).append(" ").append(dist[n-1][n-1]).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void bfs(int x, int y) {
        dist = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, y, 0));
        dist[x][y] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.x == n-1 && cur.y == n-1) break;
            
            for(int dir=0; dir<4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                int nCost = cur.cost + board[nx][ny];
                
                if(nCost < dist[nx][ny]) {
                    dist[nx][ny] = nCost;
                    pq.offer(new Node(nx, ny, nCost));
                }
            }
        }
    }
}