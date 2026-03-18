import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];

        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long left = 1;
        long right = arr[k-1];
        long maxLen = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long len = 0;
            for(int i=0; i<k; i++) {
                len += arr[i] / mid;
            }

            if (len < n) {
                right = mid - 1;
            } else {
                maxLen = mid;
                left = mid + 1;
            }
        }
        System.out.println(maxLen);
    }
}