import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;
    static int[][] dist;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {
            n = Integer.parseInt(br.readLine());

            board = new int[n][n];
            for(int i=0; i<n; i++) { // 0100
                String str = br.readLine();
                for(int j=0; j<str.length(); j++) {
                    board[i][j] = str.charAt(j) - '0';
                }
            }
            dijkstra(0, 0);
            
            sb.append("#").append(tc).append(" ").append(dist[n-1][n-1]).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    static void dijkstra(int x, int y) {
        dist = new int[n][n];
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[x][y] = 0;
        pq.offer(new Node(x, y, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost > dist[cur.x][cur.y]) continue;

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
    
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}