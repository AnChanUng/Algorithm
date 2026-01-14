import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int kind = 0;
        int left = 0;
        int max = 0;
        for(int right=0; right<n; right++) {
            if(count[arr[right]] == 0) {
                kind++;
            }
            count[arr[right]]++;

            while(kind > 2) {
                count[arr[left]]--;
                if(count[arr[left]] == 0) {
                    kind--;
                }
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        System.out.println(max);
    }
}