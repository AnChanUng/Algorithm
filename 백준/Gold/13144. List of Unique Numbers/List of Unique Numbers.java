import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      int[] arr = new int[n];
          
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++) {
          arr[i] = Integer.parseInt(st.nextToken());
      }

      boolean[] vis = new boolean[100001];
      long answer = 0;
      int right = 0;
      for(int left=0; left<n; left++) {
          while(right < n && !vis[arr[right]]) {
              vis[arr[right]] = true;
              right++;
          }
          answer += (right - left);
          vis[arr[left]] = false;
      }
      System.out.println(answer);
  }
}