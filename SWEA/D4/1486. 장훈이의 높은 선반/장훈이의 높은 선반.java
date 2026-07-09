import java.util.*;
import java.lang.*;
import java.io.*;
/*
    점원의 키들이 합이 선반의 높이이상이 되는 것 중 최소 값

    알고리즘: 부분집합 (완전탐색, 백트래킹)
    중복없는 조합의 합중 >= b 일때 최소값
*/
class Solution {
    static int n, b;
    static int[] height;
    static int minSum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 점원수
            b = Integer.parseInt(st.nextToken()); // 선반의 높이

            height = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            minSum = Integer.MAX_VALUE;
            dfs(0, 0);

            int result = minSum - b;
            System.out.println("#" + test_case + " " + result);
        }
    }
    static void dfs(int sum, int depth) {
        if(sum >= b) {
            minSum = Math.min(minSum, sum);
            return;
        }
        if(depth >= n) return;
        dfs(sum + height[depth], depth+1);
        dfs(sum, depth+1);
    }
}