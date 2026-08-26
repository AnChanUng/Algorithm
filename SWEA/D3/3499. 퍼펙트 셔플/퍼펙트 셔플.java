import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int test_case=1; test_case<=t; test_case++) {
            sb.append("#").append(test_case).append(" ");
    		int n = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine());
    		String[] ch = new String[n];
    		for(int i=0; i<ch.length; i++) {
    			ch[i] = st.nextToken();
    		}
    		
    		if(n % 2 == 0) {
    			for(int i=0; i<n/2; i++) {
    				sb.append(ch[i]).append(" ");
    				sb.append(ch[n/2+i]).append(" ");
    			}
    		} else {
    			for(int i=0; i<n/2; i++) {
    				sb.append(ch[i]).append(" ");
    				sb.append(ch[n/2+i+1]).append(" ");
    			}
    			sb.append(ch[n/2]);
    		}
    		sb.append("\n");
    	}
    	System.out.print(sb);
    }
}