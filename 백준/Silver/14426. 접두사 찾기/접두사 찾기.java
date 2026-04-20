import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Set<String> set = new HashSet<>();
    for(int i=0; i<n; i++) { // 집합
      String str = br.readLine();
      for(int j=1; j<=str.length(); j++) {
        set.add(str.substring(0, j));
      }
    }

    int cnt = 0;
    for(int i=0; i<m; i++) { 
      String word = br.readLine();
      if(set.contains(word)) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}