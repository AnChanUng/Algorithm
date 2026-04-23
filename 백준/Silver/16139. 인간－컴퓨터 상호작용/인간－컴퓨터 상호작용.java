import java.util.*;
import java.io.*;
/* 
   문자열 s의 l번째 부터 r번째 문자사이에 a가 몇번 나오는지 구하기

   알고리즘: 누적합
   자료구조: 배열

   1. for문 i<s.length();
   2. s.substring(l, r+1)에서 a가 나오면 카운트
   3. 카운트 출력
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine()); // 질문의 수
        for(int t=0; t<q; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken(); 
            int l = Integer.parseInt(st.nextToken()); // 문자열 구간
            int r = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int i=l; i<=r; i++) {
                char ch = s.charAt(i);
                if(String.valueOf(ch).equals(str)) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}