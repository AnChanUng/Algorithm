import java.io.*;
import java.util.*;
/*
 * 나보다 키가 큰사람, 나보다 작은사람 더해서 n-1과 같으면 카운트
 * 
 * 알고리즘: dfs
 * 
 */
public class Solution {	
	static List<Integer>[] high;
	static List<Integer>[] low;
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
			
			high = new List[n+1];
			low = new List[n+1];
			for(int i=1; i<=n; i++) {
				high[i] = new ArrayList<>();
				low[i] = new ArrayList<>();
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				high[a].add(b);
				low[b].add(a);
			}

			int person = 0; 
			for(int i=1; i<=n; i++) {
				vis = new boolean[n+1];
				cnt = 0;
				dfs(i, high);
				
				vis = new boolean[n+1];
				dfs(i, low);

				if(cnt == n-1) {
					person++;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(person).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void dfs(int node, List<Integer>[] graph) {
		vis[node] = true;
		for(int next : graph[node]) {
			if(!vis[next]) {
				cnt++;
				dfs(next, graph);
			}
		}
	}
}