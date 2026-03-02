import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w];
        int maxH = 0;
        int maxIdx = 0;
        int total = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(maxH < arr[i]) {
                maxH = arr[i];
                maxIdx = i;
            }
        }

        int cur = 0;
        for(int i=0; i<maxIdx; i++) {
            cur = Math.max(cur, arr[i]);
            total += cur - arr[i];
        }

        cur = 0;
        for(int i=w-1; i>maxIdx; i--) {
            cur = Math.max(cur, arr[i]);
            total += cur - arr[i];
        }
        
        System.out.print(total);
    }
}