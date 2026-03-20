import java.util.*;
import java.io.*;
// 두 용액을 더해서 가장 0에 가까운 수 두개를 출력
class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      int[] arr = new int[n];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++) {
          arr[i] = Integer.parseInt(st.nextToken());
      }
      
      int left = 0;
      int right = n-1;
      long minNum = Integer.MAX_VALUE;
      int[] res = new int[2];
      while(left < right) {         
          int num = arr[left] + arr[right];
          //System.out.println("left: " + left + " right: " + right + " num: " + num);
          if(Math.abs(num) < minNum) {
              minNum = Math.abs(num);
              res[0] = arr[left];
              res[1] = arr[right];
          }
          
          if(num < 0) {
              left++;
          } else if (num > 0) {
              right--;
          } else {
              break;
          }
      }
      System.out.println(res[0] + " " + res[1]);
  }
}