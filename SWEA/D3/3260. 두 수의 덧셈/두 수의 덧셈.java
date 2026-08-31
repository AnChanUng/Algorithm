import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*
	A + B를 더한다
*/
class Solution {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int t = Integer.parseInt(br.readLine());

    	for(int test_case=1; test_case<=t; test_case++) {
    		st = new StringTokenizer(br.readLine());
    		
    		BigInteger a = new BigInteger(st.nextToken());
    		BigInteger b = new BigInteger(st.nextToken());
    		
    		BigInteger result = a.add(b);
    		
    		sb.append("#").append(test_case).append(" ").append(result).append("\n");
    	}
    	System.out.print(sb);
    }
}