import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int total = 0;
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      total += arr[i];
    }

    int right = 0;
    int sum = 0;
    int maxSum = 0;
    for(int left = 0; left<n; left++) {
      while(sum < total / 2 && (right - left) < n) {
        sum += arr[right % n];
        right++;
      }
      maxSum = Math.max(maxSum, Math.min(sum, total-sum));
      sum -= arr[left];
    }
      
    System.out.print(maxSum);
  }
}