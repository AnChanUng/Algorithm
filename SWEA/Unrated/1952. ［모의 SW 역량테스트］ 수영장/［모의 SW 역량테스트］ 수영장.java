import java.util.*;
import java.io.*;
/*
 * 가장 적은 비용으로 수영장 이용하기
 *  
 * 알고리즘: dfs, 부분집합
 * 
 * dfs(int depth, int fee)
 * 1. 1일 이용권을 이용할 경우
 * 2. 1달 이용권을 이용할 경우
 * 3. 3달 이용권을 이용할 경우
 * 4. 1년 이용권을 이용할 경우
 * 
 * depth가 12개면 현재 fee return
 * 현재 fee가 최대값보다 크면 갱신
 */
class Solution {
	static int[] plan;
	static int day, month, threeMonth, year;
	static int minFee;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=t; test_case++) {
            st = new StringTokenizer(br.readLine());
            
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            threeMonth = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            
            plan = new int[12];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<12; i++) {
            	plan[i] = Integer.parseInt(st.nextToken());
            }
            
            minFee = Integer.MAX_VALUE;
            dfs(0, 0);
            
            sb.append("#").append(test_case).append(" ").append(Math.min(minFee, year)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static void dfs(int depth, int fee) {
    	if(minFee < fee) return;
    	
    	if(depth >= 12) {
    		minFee = fee;
    		return;
    	}
    	
    	dfs(depth+1, fee + plan[depth] * day);
    	dfs(depth+1, fee + month);
    	dfs(depth+3, fee + threeMonth);
    }
}