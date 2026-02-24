import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static String s, t;
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        dfs(t);
        if(flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(String cur) {
        if(cur.equals(s)) {
            flag = true;
            return;
        }
        if(cur.length() < s.length()) return;

        if(cur.charAt(cur.length() - 1) == 'A') {
            String next = cur.substring(0, cur.length()-1);
            dfs(next);
        }
        if(cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur);
            sb.reverse();
            sb.setLength(sb.length() - 1);
            dfs(sb.toString());
        }
    }
}