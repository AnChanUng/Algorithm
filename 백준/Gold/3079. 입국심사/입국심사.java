import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 입국심사대 개수
    int m = Integer.parseInt(st.nextToken()); // 친구 수

    int[] arr = new int[n];
    long maxTime = 0;
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      maxTime = Math.max(maxTime, arr[i]);
    }

    long low = 1;
    long high = (long) maxTime * m;
    long maxAns = 0;
    while(low <= high) {
      long mid = (low + high) / 2;
      
      long answer = 0;
      for(int i=0; i<n; i++) {
        answer += mid / arr[i];
        if(answer >= m) break;
      }
      
      if(answer >= m) {
        maxAns = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    System.out.println(maxAns);
  }
}