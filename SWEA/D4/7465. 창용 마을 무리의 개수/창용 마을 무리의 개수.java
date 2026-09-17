import java.io.*;
import java.util.*;
/*
 * n명의 사람이 1~N번호를 붙이고 있다.
 * 서로 아는 사람끼리를 나타내는 번호 2개가 주어지는데
 * 건너건너 아는사람끼리 무리라고 했을 때, 몇 무리인지
 * 
 * 알고리즘: 그래프 dfs, 인접리스트
 * 
 * 각 주어진 숫자들을 통해 인접리스트를 만든다
 * dfs(int node)
 * - dfs를 1번부터 돌면서 호출되는 횟수를 구한다
 */
public class Solution {	
	static List<Integer>[] graph;
	static boolean[] vis;
	static int n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			graph = new List[n+1];
			vis = new boolean[n+1];
			for(int i=1; i<=n; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				if(!vis[i]) {
					dfs(i);
					cnt++;
				}
			}
		
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}
	private static void dfs(int node) {
		vis[node] = true;
		for(int next : graph[node]) {
			if(!vis[next]) {
				dfs(next);
			}
		}
	}
}