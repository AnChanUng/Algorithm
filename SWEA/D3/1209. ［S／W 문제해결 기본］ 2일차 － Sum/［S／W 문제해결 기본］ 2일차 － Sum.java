import java.io.*;
import java.util.*;
/*
 * 100*100 배열의 행, 열, 대각선의 합 중 최대값 구하기
 * 
 *  1.1 테스트케이스 수 10개 입력받기
 *  1.2 테스트 케이스 번호 입력 받기
 *  1.3 배열 입력 받기
 *  2.  가로 세로 대각선 구하기
 *  3.  가로 세로 대각선중 가장 큰 값 출력하기
 */
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가로의 합, 세로의 합
			int maxGaro = 0;
			int maxSero = 0;
			for(int i=0; i<100; i++) {
				int sumGaro = 0;
				int	sumSero = 0;
				for(int j=0; j<100; j++) {
					sumGaro += arr[i][j];
					sumSero += arr[j][i];
				}
				maxGaro = Math.max(maxGaro, sumGaro);
				maxSero = Math.max(maxSero, sumSero);
			}

			// 대각선의 합
			// arr[0][99] + arr[1][98] + arr[2][97] .... arr[99][0]
			int leftLine = 0;
			int rightLine = 0;
			for(int i=0; i<100; i++) {
				rightLine += arr[i][99-i];
				for(int j=0; j<100; j++) {
					if(i == j) {
						leftLine += arr[i][j];
					}
				}
			}
			// 가로 세로 대각선중에 가장 큰 수 출력
			int Line = Math.max(leftLine, rightLine);
			int result = Math.max(Line, Math.max(maxGaro, maxSero));
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}