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

        int answer = 0;
        for(int i=0; i<n; i++) {
            int count = 0;
            double maxSlope = Integer.MIN_VALUE;
            for(int j=i+1; j<n; j++) {
                double slope = (double)(arr[j] - arr[i]) / (j - i);
                if(slope > maxSlope) {
                    maxSlope = slope;
                    count++;
                }
            }
            maxSlope = Integer.MIN_VALUE;
            for(int j=i-1; j>=0; j--) {
                double slope = (double)(arr[j] - arr[i]) / (i-j);
                if(slope > maxSlope) {
                    maxSlope = slope;
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }  
}