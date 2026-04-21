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

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int cnt = 0;
        int left = 0;
        int right = n-1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            
            if(sum > x) {
                right--;
            } else if (sum < x) {
                left++;
            } else {
                cnt++;
                left++;
            }
        }
        System.out.println(cnt);
    }
}