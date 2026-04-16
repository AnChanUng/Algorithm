import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); 
    int k = Integer.parseInt(st.nextToken()); 

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // k개 이상이지만 가장 작은 연속된 집합의 크기
    int left = 0;
    int minLen = Integer.MAX_VALUE;
    int cnt = 0;
    for(int right=0; right<n; right++) {
      if(arr[right] == 1) cnt++;
      while(cnt >= k) {
        //System.out.println("left: " + left + " right: " + right + " cnt: " + cnt);
        minLen = Math.min(minLen, right - left + 1);
        if(arr[left] == 1) {
          cnt--;
        } 
        left++;
      }
    }
    if(minLen == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(minLen);
    }
  }
}