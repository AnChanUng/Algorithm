import java.util.*;
import java.lang.*;
import java.io.*;
/* 
    1,2,3으로 이루어진 n자리의 수열중 가장 작은 수 출력
    - 수열, 백트래킹
*/
class Main {
    static int n;
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs("");
    }
    static void dfs(String str) {
        if(flag) return;
        if(str.length() == n) {
            System.out.println(str);
            flag = true;
            return;
        }
        for(int i=1; i<=3; i++) {
            String next = str + i;
            if(isGood(next)) {
                dfs(next);
            }
        }
    }
    static boolean isGood(String str) {
        int len = str.length();
        for(int i=1; i<=len/2; i++) {
            String last = str.substring(len-i, len);
            String prev = str.substring(len - 2*i, len-i);
            if(last.equals(prev)) {
                return false;
            }
        }
        return true;
    }
}