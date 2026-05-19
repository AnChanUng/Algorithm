import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int len = Integer.parseInt(br.readLine());
			
			String[][] arr = new String[8][8];
			
			for(int i=0; i<8; i++) {
				String str = br.readLine();
				for(int j=0; j<8; j++) {
					arr[i][j] = String.valueOf(str.charAt(j));
				}
			}
			
			int cnt = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<8-len+1; j++) {
					sb = new StringBuilder();
					for(int k=0; k<len; k++) {
						sb.append(arr[i][j+k]);
					}
					
					String str = sb.toString();
					String reverseSb = new StringBuilder(str).reverse().toString();
					
					if(str.equals(reverseSb)) {
						//System.out.println("sb: " + sb + " " + sb.reverse());
						cnt++;
					}
				}
			}
			
			for(int i=0; i<8; i++) {
				for(int j=0; j<8-len+1; j++) {
					sb = new StringBuilder();
					for(int k=0; k<len; k++) {
						sb.append(arr[j+k][i]);
					}
					
					String sero = sb.toString();
					String reverseSero = new StringBuilder(sero).reverse().toString();
					
					if(sero.equals(reverseSero)) {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}