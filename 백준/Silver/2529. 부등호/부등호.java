import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static String[] oper;
    static boolean[] vis;
    static int k;
    static String minNum = "";
    static String maxNum = "";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        oper = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            oper[i] = st.nextToken();
        }
        vis = new boolean[10];
        
        dfs("", 0, 0);
        System.out.println(maxNum);
        System.out.println(minNum);
    }
    static void dfs(String str, int depth, int prev) {
        if(depth == k+1) {
            if(maxNum.equals("") || str.compareTo(maxNum) > 0) maxNum = str;
            if(minNum.equals("") || str.compareTo(minNum) < 0) minNum = str;
            return;
        }
        for(int i=0; i<10; i++) {
            if(!vis[i]) {
                if(depth > 0) {
                    if(oper[depth-1].equals("<")) if(prev > i) continue;
                    if(oper[depth-1].equals(">")) if(prev < i) continue;
                }
                vis[i] = true;
                dfs(str + String.valueOf(i), depth+1, i);
                vis[i] = false;
            }
        }
    }
}