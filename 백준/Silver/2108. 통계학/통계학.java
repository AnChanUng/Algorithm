import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        int sum = 0;
        for(int a : arr) {
            sum += a;
        }

        int average = Math.round((float) sum / n);

        Arrays.sort(arr);

        boolean check = false;
        int count = 0;
        int max = -1;
        int mod = arr[0];
        for(int i=0; i<n-1; i++){
            if(arr[i] == arr[i+1]) {
                count++;
            } else {
                count = 0;
            }

            if(max < count) {
                max = count;
                mod = arr[i];
                check = true;
            } else if(max == count && check == true) {
                mod = arr[i];
                check = false;
            }
        }
         
        System.out.println(average);
        System.out.println(arr[(n-1)/2]);
        System.out.println(mod);
        System.out.println(arr[n-1] - arr[0]);
    }
}