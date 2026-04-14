import java.util.*;
import java.io.*;
/*
  숫자: 1~9
  부등호 만족

  순열 백트래킹
*/
class Main {
  static int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
  static boolean[] vis;
  static String[] oper;
  static int k;
  static String maxStr = null;
  static String minStr = null;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    k = Integer.parseInt(br.readLine());

    oper = new String[k];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<k; i++) {
      oper[i] = st.nextToken();
    }

    vis = new boolean[num.length];
    dfs("", 0, 0);
    
    System.out.println(maxStr);
    System.out.println(minStr);
  }
  static void dfs(String str, int depth, int prev) {
    if(depth == k+1) {
      if(maxStr == null || str.compareTo(maxStr) > 0) maxStr = str;
      if(minStr == null || str.compareTo(minStr) < 0) minStr = str;
      return;
    }

    for(int i=0; i<num.length; i++) {
      if(!vis[i]) {
        if(depth > 0) {
          if(oper[depth-1].equals("<") && !(prev < num[i])) continue;
          if(oper[depth-1].equals(">") && !(prev > num[i])) continue; 
        } 
        vis[i] = true;
        dfs(str + num[i], depth+1, num[i]);
        vis[i] = false;
      }
    }
  }
}