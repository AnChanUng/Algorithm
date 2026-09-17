
import java.io.*;
import java.util.*;
/*
 * 모두를 혼자인 무리로 초기화
 * 간선을 읽을 때마다 무리를 합침
 * 루트인 노드를 세기 (=무리의 개수)
 */
public class Solution {	
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			for(int i=1; i<=n; i++) {
				parent[i] = i;
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				if(find(i) == i) {
					cnt++;
				}
			}
		
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static boolean union(int a, int b) {
		a = find(a);                                      
		b = find(b);
		if(a == b) return false;     
		parent[b] = a;                                     
		return true;
	}
}