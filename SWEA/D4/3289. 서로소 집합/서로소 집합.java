import java.io.*;
import java.util.*;
/*
 * 1 ~ n 만들기
 * k가 0 이면 union
 * k가 1이면 find(a) find(b) 해서 집합에 속해있으면 1 아니면 0
 */
public class Solution {	
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());	
		
		for(int test_case=1; test_case<=t; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			for(int i=1; i<=n; i++) {
				parent[i] = i;
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(k == 0) {
					union(a, b);
				} else {
					if(find(a) == find(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			
			sb.append("\n");
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