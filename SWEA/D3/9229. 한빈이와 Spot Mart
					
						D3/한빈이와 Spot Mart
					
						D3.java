import java.io.*;
import java.util.*;
/*
  과자 두봉지를 샀을 때 m을 초과하지 않는 최대합
*/
class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for(int test_case=1; test_case<=T; test_case++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // 과자 봉지 개수
      int m = Integer.parseInt(st.nextToken()); // 무게 합 제한

      int[] arr = new int[n];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      int maxSum = -1;
      for(int i=0; i<n; i++) {
        for(int j=i+1; j<n; j++) {
          int sum = arr[i] + arr[j];
          if(sum > m) continue;
          if(maxSum < sum) {
            maxSum = sum;
          }
        }
      }
      System.out.println("#" + test_case + " " + maxSum);
    }
  }
}