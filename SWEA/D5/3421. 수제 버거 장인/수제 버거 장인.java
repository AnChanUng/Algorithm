import java.util.*;
import java.io.*;
/*
 * a,b가 포함되지 않는 조합구하기 (nC1 부터 nCn)
 * 
 * 알고리즘: 조합 DFS 
 * 1 ~ N을 배열에 저장한다
 * 
 * 탐색한 숫자의 개수
 * dfs(int start, int depth)
 * a, b가 들어가는 경우를 제외한다
 * 나머지 조합을 구한다
 */
public class Solution {
	static boolean[] pick;
	static int[] arr;
	static int[][] index;
	static int n, m;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			index = new int[m][2];
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				index[i][0] = a;
				index[i][1] = b;
			}

			pick = new boolean[n];
			arr = new int[n];
			for(int i=1; i<=n; i++) {
				arr[i-1] = i;
			}
			
			cnt = 0;
			dfs(0);
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}
	static void dfs(int depth) {
		if(depth == n) {
			if(isValid()) {
				cnt++;
			}
			return;
		}
		
		pick[depth] = true;
		dfs(depth+1);
			
		pick[depth] = false;
		dfs(depth+1);
	}
	
	static boolean isValid() {
		for(int j=0; j<m; j++) {
			int a = index[j][0];
			int b = index[j][1];
			
			if(pick[a-1] && pick[b-1]) return false;
		}
		return true;
	}
}