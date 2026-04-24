import java.util.*;
import java.io.*;
/* 
   1~n의 수에 +나 -를 삽입하고 결과가 0이 되는 경우의 수

   알고리즘: dfs
*/
public class Main {
    static int t, n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        t = Integer.parseInt(br.readLine());

        for(int test=0; test<t; test++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            dfs("1", 2, 1);
            System.out.println();
        }
    }
    static void dfs(String str, int start, int depth) {
        if(depth == n) {
            if(calc(str) == 0) {
                System.out.println(str);
            }
            return;
        }
        for(int i=start; i<=n; i++) {
            dfs(str + " " + i, i+1, depth+1);
            dfs(str + "+" + i, i+1, depth+1);
            dfs(str + "-" + i, i+1, depth+1);
        }
    }
    static int calc(String str) {
        int sum = 0;
        int sign = 1;
        int num = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                sum += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                sum += sign * num;
                num = 0;
                sign = -1;
            }
        }
        sum += sign * num;
        return sum;
    }
}