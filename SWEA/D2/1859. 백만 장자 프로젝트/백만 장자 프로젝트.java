import java.util.*;
import java.io.*;
/*
  1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
  2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
  3. 판매는 얼마든지 할 수 있다.
*/
class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    
    for(int test=1; test<=t; test++) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int maxNum = Integer.MIN_VALUE;
      for(int i=0; i<n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      long total = 0;
      for(int i=n-1; i>=0; i--) {
        maxNum = Math.max(maxNum, arr[i]);
        if(arr[i] < maxNum) {
          total += maxNum - arr[i];
        }
      }
      
      System.out.println("#" + test + " " + total);
    }
  } 
}