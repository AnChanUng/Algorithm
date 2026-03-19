import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 나무의 길이

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
          arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n-1];
        int maxMid = 0;
        while(left <= right) {
          int mid = (left + right) / 2;
          long total = 0;
          for(int i=0; i<n; i++) {
            if(arr[i] < mid) { // 지정한 높이보다 작으면 -> 현재높이 = 그대로
              continue;
            } else { // 지정한 높이보다 높으면 -> 현재높이 = 지정한 높이
              total += arr[i] - mid;
            }
          }

          if(total >= m) { // m이 최대면 maxMid값 mid로 변경
              maxMid = Math.max(maxMid, mid);
              left = mid + 1;
              //System.out.println("maxMid: " + maxMid + " left: " + left);
          } else {
              right = mid - 1;
              //System.out.println("maxaMid: " + maxMid + " right: " + right);
          } 
        }
        System.out.println(maxMid);
    }
}