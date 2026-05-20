import java.util.*;
import java.io.*;
/*
  제한 칼로리(l)이하의 점수중에서 점수(t의 합)가 가장 큰 것 구하기

  알고리즘: dfs (부분집합)
*/
class Solution {
  static int n, l;
  static int t, k;
  static int[][] arr;
  static int maxSum;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for(int test_case=1; test_case<=T; test_case++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken()); // 재료의 수
      l = Integer.parseInt(st.nextToken()); // 제한 칼로리

      arr = new int[n][2];
      for(int i=0; i<n; i++) {
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken()); // 맛에 대한 점수
        k = Integer.parseInt(st.nextToken()); // 칼로리

        arr[i][0] = t;
        arr[i][1] = k;
      }

      maxSum = 0;
      dfs(0, 0, 0);     

      System.out.println("#" + test_case + " " + maxSum);
    }
  }
  static void dfs(int idx, int sumScore, int sumCal) {
    if(idx == n) {
      if(sumCal <= l) {
        maxSum = Math.max(maxSum, sumScore);
      }
      return;
    }
    dfs(idx+1, sumScore + arr[idx][0], sumCal + arr[idx][1]);
    dfs(idx+1, sumScore, sumCal);
  }
}