import java.io.*;
import java.util.*;
/* 합이 0이 되는 조합 */
class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test=0; test<t; test++) {
            n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            dfs(2, "1");

            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static void dfs(int idx, String str) {
        if(idx == n + 1) {
            if(calculate(str) == 0) {
                sb.append(str).append("\n");
            }
            return;
        }
        
        dfs(idx+1, str + " " + idx);
        dfs(idx+1, str + "+" + idx);
        dfs(idx+1, str + "-" + idx);    
    }

    static int calculate(String str) {
        str = str.replace(" ", "");

        int sum = 0;
        int num = 0;
        char op = '+';

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else {
                if(op == '+') sum += num;
                else sum -= num;

                op = ch;
                num = 0;
            }
        }

        if(op == '+') sum += num;
        else sum -= num;

        return sum;
    }
}