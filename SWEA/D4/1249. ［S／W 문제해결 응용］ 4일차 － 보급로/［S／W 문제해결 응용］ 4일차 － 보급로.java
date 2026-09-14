import java.io.*;
import java.util.*;
/*
 * 출발지에서 도착지까지 가는 경로 중에 복구 시간이 가장 짧은 경로에 대한 총 복구 시간
 * 
 * 알고리즘: 다익스트라 BFS
 * 
 * - 출발지에서 출발
 * - BFS로 각 탐색하며 가중치를 확인하고 최소 값으로 이동
 * - 도착지에 도착했을 때, 비용이 가장 적은 값 출력
 */
public class Solution {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] graph;
	static int[][] dist;
	static int n;
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
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			n = Integer.parseInt(br.readLine());
			
			graph = new int[n][n];

			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<n; j++) {
					graph[i][j] = str.charAt(j) - '0';
				}
			}

			bfs(0, 0);
			
			sb.append("#").append(test_case).append(" ").append(dist[n-1][n-1]).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void bfs(int x, int y) {
        dist = new int[n][n];
        for(int i=0; i<dist.length; i++) {
        	Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(x, y, 0));
		dist[x][y] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
            
            if(cur.cost > dist[cur.x][cur.y]) continue;
            if(cur.x == n-1 && cur.y == n-1) return;
			for(int dir=0; dir<4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				
				int nCost = cur.cost + graph[nx][ny];
				
				if(nCost < dist[nx][ny]) {
                    dist[nx][ny] = nCost;
                    pq.offer(new Node(nx, ny, nCost));
                }
			}
		}
	}
}