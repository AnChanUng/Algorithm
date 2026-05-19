import java.io.*;
import java.util.*;
/*
 * 덤프 횟수만큼 옮겨서 평탄화 작업을해서 가장 큰 숫자와 가장 작은 숫자를 빼기
 */
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int dump = Integer.parseInt(br.readLine()); // 덤프 횟수
			st = new StringTokenizer(br.readLine());
			int len = st.countTokens();
			int[] arr = new int[len];
			for(int i=0; i<len; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			while(cnt < dump) {
				cnt++;
				Arrays.sort(arr);
				
				arr[len-1]--;
				arr[0]++;
			}
			
			Arrays.sort(arr);
			
			int diff = arr[len-1] - arr[0];
			
			System.out.println("#" + test_case + " " + diff);
		}
		
	}
}