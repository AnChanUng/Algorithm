import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = 10;

    for(int test_case=1; test_case<=T; test_case++) {
      int tc = Integer.parseInt(br.readLine());
      String find = br.readLine();
      String str = br.readLine();

      int findLen = find.length();

      int cnt = 0;
      for(int i=0; i<str.length()-findLen+1; i++) {
        String word = str.substring(i, i+findLen);
        if(word.equals(find)) {
          cnt++;
        }
      }
      System.out.println("#" + test_case + " " + cnt);
    }
  }
}