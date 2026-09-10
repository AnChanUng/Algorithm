import java.util.*;
import java.io.*;
/*
 *  1 ~ N개를 선택했을 때, 나오는 조합중에서 탑의 높이가 가장 낮은 것 구하기
 * 
 	알고리즘: 조합 dfs
 
 	dfs
 	- 1 ~ n개를 선택하는 경우의 수를 모두 구한다.
 	- 선택한 조합을 더했을 때, b보다 높은 것만 구한다.
 	- b보다 높은 것 중에 가장 작은 것을 구한다.
 */
class Solution {
	static int[] arr;
	static boolean[] vis;
	static int n, b;
	static int minHeight;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=t; test_case++) {
            st = new StringTokenizer(br.readLine());
            
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            arr = new int[n];
            vis = new boolean[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            minHeight = Integer.MAX_VALUE;
            dfs(0);
            
            int result = minHeight - b;
            
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
   /*
    * depth: 숫자를 선택한 인덱스 개수
    */
    static void dfs(int depth) {
    	if(depth >= n) {
    		int sum = 0;
    		for(int i=0; i<n; i++) {
    			if(vis[i]) {
    				sum += arr[i];
    			}
    		}
    		if(sum >= b) {
    			minHeight = Math.min(minHeight, sum);
    		}
    		return;
    	}
    	
    	vis[depth] = true;
	    dfs(depth+1);
	    	
	    vis[depth] = false;
	    dfs(depth+1);
    }
}