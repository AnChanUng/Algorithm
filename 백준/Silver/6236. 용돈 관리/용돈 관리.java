import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 나무의 길이

        int[] arr = new int[n];

        int left = 0;
        int right = 0;
        int minMid = Integer.MAX_VALUE; 

        for(int i=0; i<n; i++) {
          arr[i] = Integer.parseInt(br.readLine());
          left = Math.max(left, arr[i]);
          right += arr[i];
        }

        while(left <= right) {
          int mid = (left + right) / 2; // 인출할 금액
          int cnt = 1;
          int money = mid;
          // 인출횟수가 m회 여야함
          for(int i=0; i<n; i++) {
            if(money - arr[i] >= 0) {
              money = money - arr[i];
            } else {
              cnt++;
              money = mid;
              money = money - arr[i];
            }
          }

          if(cnt <= m) {
            minMid = Math.min(minMid, mid);
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        }
        // k의 최소 값
        System.out.println(minMid);
    }
}