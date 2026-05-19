import java.io.*;
import java.util.*;
/*
 * 1. 8개의 숫자 입력 받기
 * 2. 싸이클
 * 2.1 첫 번째 숫자를 1 감소한 뒤, 맨뒤로 보내기
 * 2.2 첫 번째 숫자를 2 감소한 뒤, 맨뒤로 보내기
 * 2.3 첫 번째 숫자를 3 감소한 뒤, 맨뒤로 보내기
 * 2.4 첫 번째 숫자가 0이 되었을 때, 맨뒤로 보내고 해당 배열 출력하기
 */
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				int x = Integer.parseInt(st.nextToken());
				q.add(x);
			}
			
			int num = 1;
			while(true) {
				int cur = q.poll();
				if(cur - num <= 0) {
					q.add(0);
					break;
				} else {
					q.add(cur - num);
				}
				num++;
				if(num >= 6) num = 1;
				//System.out.println("num: " + num + " cur: " + cur);
			}
			
			System.out.println("#" + test_case + " ");
			for(int x : q) {
				System.out.print(x + " ");
			}
		}
	}
}