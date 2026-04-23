import java.util.*;
import java.io.*;
/* 
   문자열 s의 l번째 부터 r번째 문자사이에 a가 몇번 나오는지 구하기

   알고리즘: 누적합
   자료구조: 배열
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        String s = br.readLine();
        
        int[][] count = new int[s.length()+1][26];
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<26; j++) {
                count[i+1][j] = count[i][j];
            }
            count[i+1][s.charAt(i)-'a']++;
        }
        
        int q = Integer.parseInt(br.readLine()); // 질문의 수
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<q; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken(); 
            int l = Integer.parseInt(st.nextToken()); // 문자열 구간
            int r = Integer.parseInt(st.nextToken());

            int res = count[r+1][str.charAt(0) - 'a'] - count[l][str.charAt(0) - 'a'];
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }
}