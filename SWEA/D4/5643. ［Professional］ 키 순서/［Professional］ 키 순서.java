import java.io.*;
import java.util.*;
/*
 * 인접리스트 DFS
 */
public class Solution {
	static List<Integer>[] up;
	static List<Integer>[] down;
	static boolean[] vis;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			up = new List[n+1];
			down = new List[n+1];
			for(int i=1; i<=n; i++) {
				up[i] = new ArrayList<>();
				down[i] = new ArrayList<>();
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				up[a].add(b);
				down[b].add(a);
			}
			
			int total = 0;
			int answer = 0;
			for(int i=1; i<=n; i++) {
				vis = new boolean[n+1];
				cnt = 0;
				dfs(i, up);
				total = cnt;

				vis = new boolean[n+1];
				cnt = 0;
				dfs(i, down);
				total += cnt;
				
				if(total == n-1) {
					answer++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	static void dfs(int node, List<Integer>[] graph) {
		vis[node] = true;
		for(int next : graph[node]) {
			if(!vis[next]) {
				vis[next] = true;
				cnt++;
				dfs(next, graph);
			}
		}
	}
}