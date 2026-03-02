import java.util.*;
import java.lang.*;
import java.io.*;
/* 
    산성, 알칼리성
    특성값: 산성 특성값 + 알칼리성 특성값

    0에 가장 가까운 혼합 용액 만들기
*/
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
        int minValue = Integer.MAX_VALUE;
        int leftValue = 0;
        int rightValue = 0;
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);
            
            if(absSum < minValue) {
                minValue = absSum;
                leftValue = arr[left];
                rightValue = arr[right];
            }

            if(sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.print(leftValue + " " + rightValue);
    }
}