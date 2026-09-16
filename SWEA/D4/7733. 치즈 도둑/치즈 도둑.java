import java.util.*;
import java.io.*;
/*
 * 100일 중에서 치즈덩어리가 가장 많을 때의 덩어리 개수를 구하는 프로그램
 * 
 * 100일 동안 치즈를 먹는데 X번째 날에 x인 칸을 먹는다
 * 
 * while(일수++)
 * 
 * 치즈값이 일수와 겹치는 것을 0으로 변경한다.
 * 덩어리가 몇개인지 센다.
 * 덩어어리 최대값이면 갱신한다.
 */
public class Solution {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] board;
	static boolean[][] vis;
	static int n, time;
	static int maxCnt;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        for(int test_case=1; test_case<=t; test_case++) {
            n = Integer.parseInt(br.readLine());
            
            board = new int[n][n];
            
            for(int i=0; i<n; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j=0; j<n; j++) {
            		board[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            maxCnt = 1;
            time = 0;
            while(time < 100) {
            	vis = new boolean[n][n];
            	time++;
            	int cnt = 0;
            	for(int i=0; i<n; i++) {
            		for(int j=0; j<n; j++) {
            			if(board[i][j] > time && !vis[i][j]) {
            				bfs(i, j);
            				cnt++;
            			}
            		}
            	}
            	if(maxCnt < cnt) {
            		maxCnt = cnt;
            	}
            }
            sb.append("#").append(test_case).append(" ").append(maxCnt).append("\n");
        }
        System.out.println(sb.toString());
	}	
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x, y});
		vis[x][y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if(vis[nx][ny]) continue;
				if(board[nx][ny] <= time) continue;
				q.offer(new int[]{nx, ny});
				vis[nx][ny] = true;
			}
		}
	}
}