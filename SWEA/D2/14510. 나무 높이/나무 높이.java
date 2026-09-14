import java.io.*;
import java.util.*;

public class Solution {
	static int[] treeHeight;
	static int[] diff;
	public static	 void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			
			treeHeight = new int[n];
			diff = new int[n];
			
			int maxHeight = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				treeHeight[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, treeHeight[i]);
			}
			
			for(int i=0; i<n; i++) {
				diff[i] = maxHeight - treeHeight[i];
			}
			
			int answer = count();
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	static int count() {
		int one = 0;
		int two = 0;
		for(int i=0; i<diff.length; i++) {
			if(diff[i] % 2 == 0) {
				two += diff[i] / 2;
			} else {
				one += 1;
				two += diff[i] / 2;
			}
		}
		
		int time = 0;
		int save = 0;
		while(one > 0 || two > 0) {
			time++;
			if(time % 2 == 1) {
				if(one > 0) {
					one -= 1;
				} else {
					save += 1;
					if(save == 2) {
						save = 0;
						if(two > 0) two -= 1;
					}
				}
			} else {
				if(two > 0) {
					two -= 1;
				}
			}
		}
		return time;
	}
}