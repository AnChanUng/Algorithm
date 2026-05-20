import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int wordLen = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			StringBuilder sb = new StringBuilder(str);
			
			int idx = 0;
			while(idx < sb.length()-1) {
				char ch1 = sb.charAt(idx);
				char ch2 = sb.charAt(idx+1);
				if(ch1 == ch2) {
					sb.delete(idx, idx+2);
					if(idx > 0) idx--;
				} else {
					idx++;
				}
			}
			System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}