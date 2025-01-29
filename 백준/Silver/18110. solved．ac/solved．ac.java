import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        int sum = 0;
        int cnt = 0;
        
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int num = (int) Math.round(n * 0.15);
        
        for(int i=num; i<n-num; i++) {
            sum += arr[i];
            cnt++;
        }
        
        if(cnt == 0) {
            System.out.println(sum);
        } else {
            double result = (double) sum / cnt;
            System.out.println(Math.round(result));
        }
    }
}