import java.io.*;
import java.util.*;
/*
    알고리즘: 시뮬레이션
	
	1. 8개의 숫자를 입력받는다
	2.1 첫번째 수를 1 감소한 뒤, 맨 뒤로 보낸다.
	2.2 첫번째 수를 2,3,4,5 감소한 뒤, 맨 뒤로 보낸다.
	2.3 첫번째 수가 0보다 작아지는 경우 맨 뒤로 보내고 프로그램을 종료한다.
	3. 현재 큐를 출력한다.
*/
class Solution {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;

    	for(int test_case=1; test_case<=10; test_case++) {
    		Deque<Integer> q = new ArrayDeque<>();
    		
    		int t = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine());
    		for(int i=0; i<8; i++) {
    			q.offer(Integer.parseInt(st.nextToken()));
    		}
    		
    		int cnt = 1;
    		while(true) {
    			int cur = q.poll();

    			if(cur - cnt <= 0) {
    				q.offer(0);
    				break;
    			} else {
    				q.offer(cur - cnt);
    			}
    			
    			cnt++;
    			if(cnt >= 6) cnt = 1;
    		}

    		sb.append("#").append(test_case).append(" ");
    		while(!q.isEmpty()) {
    			int cur = q.poll();
    			sb.append(cur).append(" ");
    		}
    		sb.append("\n");
    	}
    	System.out.print(sb);
    }
}