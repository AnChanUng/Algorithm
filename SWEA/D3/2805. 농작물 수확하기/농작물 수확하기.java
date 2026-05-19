import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 농장의 크기
			
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				String inputs = br.readLine();
				for(int j=0; j<inputs.length(); j++) {
					char ch = inputs.charAt(j);
					arr[i][j] = ch - '0';
				}
			}
			
			int total = 0;
			for(int i=0; i<n/2; i++) {
				for(int j=n/2-i; j<=n/2+i; j++) {
					total += arr[i][j];
					total += arr[n-i-1][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				total += arr[n/2][i];
			}
			
			System.out.println("#" + test_case + " " + total);
		}
	}
}