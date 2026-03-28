import java.util.*;
import java.lang.*;
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

        int cnt = 0;
        for(int i=0; i<n; i++) {
            int left = 0;
            int right = n-1;
            while(left < right) {
                if(left == i) { left++; continue; }
                if(right == i) { right--; continue; }
                
                int sum = arr[left] + arr[right];

                if(sum < arr[i]) {
                    left++;
                } else if (sum == arr[i]) {
                    cnt++;
                    break;
                } else {
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}