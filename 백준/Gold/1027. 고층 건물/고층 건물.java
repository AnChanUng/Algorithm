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
            int cnt = 0;
            double maxScope = Integer.MIN_VALUE;
            for(int j=i+1; j<n; j++) {
                double scope = (double)(arr[j]-arr[i]) / (j - i);
                if(scope > maxScope) {
                    maxScope = scope;
                    cnt++;
                }
            }
            
            double leftScope = Integer.MIN_VALUE;
            for(int j=i-1; j>=0; j--) {
                double scope = (double)(arr[j]-arr[i]) / (i-j);
                if(scope > leftScope) {
                    leftScope = scope;
                    cnt++;
                }
            }
            answer = Math.max(cnt, answer);
        }
        System.out.println(answer);
    }  
}