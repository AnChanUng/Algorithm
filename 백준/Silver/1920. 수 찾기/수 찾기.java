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

    Arrays.sort(arr);

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<m; i++) {
      int x = Integer.parseInt(st.nextToken());
      
      int left = 0;
      int right = n-1;
      boolean flag = false;
      while(left <= right) {
        int mid = (left + right) / 2;
        if(arr[mid] == x) {
          flag = true;
          break;
        } else if (arr[mid] < x) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      if(!flag) System.out.println(0);
      else System.out.println(1);
    }
  }  
}