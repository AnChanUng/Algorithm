import java.util.*;
import java.lang.*;
import java.io.*;
/*
    명령어를 수행했을 때, 수정된 결과의 처음 10개 숫자 출력
*/
import java.util.*;
import java.lang.*;
import java.io.*;
/*
 * N X N 배열에 숫자가 주어졌을 때, M * M의 숫자의 합이 가장 큰 구간 구하기
 * 
 * 1. 배열을 입력받는다.
 * 2. M*M을 탐색하면서 현재 가장 큰수보다 크면 갱신한다.
 * 3. 가장 큰 수를 출력한다.
 */
class Solution {
	static int[][] arr;
	static int maxSum = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case=1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            arr = new int[n][n];
            
            for(int i=0; i<n; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j=0; j<n; j++) {
            		arr[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            maxSum = 0;
            for(int i=0; i<n-m+1; i++) {
            	for(int j=0; j<n-m+1; j++) {
            		int sum = 0;
            		for(int a=0; a<m; a++) {
            			for(int b=0; b<m; b++) {
            				sum += arr[i+a][j+b];
            			}
            		}
            		if(maxSum < sum) {
            			maxSum = sum;
            		}
            	}
            }
            
            sb.append("#").append(test_case).append(" ").append(maxSum).append("\n");
        }
        System.out.print(sb);
    }
}