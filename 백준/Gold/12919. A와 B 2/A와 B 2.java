import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String s, t;
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();

        dfs(t);
        if(flag) System.out.println(1);
        else System.out.println(0);
    }

    static void dfs(String cur) {
        if(cur.equals(s)) {
            flag = true;
            return;
        }

        if(cur.length() < s.length()) {
            return;
        }

        // 마지막이 a면 삭제
        if(cur.charAt(cur.length()-1) == 'A') {
            String next = cur.substring(0, cur.length()-1);
            dfs(next);
        }

        // 마지막이 b면 뒤집고 삭제
        if(cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur).reverse();
            String next = sb.toString().substring(0, cur.length()-1);
            dfs(next);
        }
    }
}