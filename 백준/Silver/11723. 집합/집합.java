import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int set = 0; // 집합을 표현하는 비트마스크

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int n = 0;

            if(st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
            }

            int mask = 1 << (n-1); // n번째 비트가 위치한 마스크
            
            if(oper.equals("add")) {
                set |= mask; // n번째 비트를 1로 설정
            } else if(oper.equals("remove")) {
                set &= ~mask; // n번째 비트를 0으로 설정
            } else if(oper.equals("check")) {
                sb.append((set & mask) != 0 ? "1\n" : "0\n"); // n번째 비트가 1인지 확인
            } else if(oper.equals("toggle")) {
                set ^= mask; // n번째 비트 반전
            } else if(oper.equals("all")) {
                set = (1 << 20) - 1; // 1부터 20까지 모든 비트를 1로 설정
            } else if(oper.equals("empty")) {
                set = 0; 
            }
        }
        System.out.print(sb.toString());
    }
}