import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int len = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			int answer = 1;
			boolean flag = false;
			ArrayList<Character> list = new ArrayList<>();
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(ch == '(') {
					list.add('(');
				} else if (ch == ')') {
					if(list.contains('(')) {
						list.remove(Character.valueOf('('));
					} else {
						answer = 0;
						flag = true;
					}
				} else if (ch == '[') {
					list.add('[');
				} else if (ch == ']') {
					if(list.contains('[')) {
						list.remove(Character.valueOf('['));
					} else {
						answer = 0;
						flag = true;
					}
				} else if (ch == '{') {
					list.add('{');
				} else if (ch == '}') {
					if(list.contains('{')) {
						list.remove(Character.valueOf('{'));
					} else {
						answer = 0;
						flag = true;
					}
				} else if (ch == '<') {
					list.add('<');
				} else if (ch == '>') {
					if(list.contains('<')) {
						list.remove(Character.valueOf('<'));
					} else {
						answer = 0;
						flag = true;
					}
				}
				if(flag) break;
			}
			if(list.size() >= 1) answer = 0;
			System.out.println("#" + test_case + " " + answer);
		}
	}
}