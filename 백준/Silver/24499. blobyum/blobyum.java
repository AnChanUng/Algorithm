import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 애플파이 개수
    int k = Integer.parseInt(st.nextToken()); // 먹으려는 애플파이 개수

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 연속으로 더했을 때, 최대값
    int sum = 0;
    for(int i=0; i<k; i++) {
      sum += arr[i];
    }

    int maxSum = sum;
    for(int i=0; i<n; i++) {
      sum += arr[(i+k) % n];
      sum -= arr[i];
      //System.out.println("i+k: " + (i+k) + " sum: " + sum);
      maxSum = Math.max(maxSum, sum);
    }
    System.out.println(maxSum);
  }
}