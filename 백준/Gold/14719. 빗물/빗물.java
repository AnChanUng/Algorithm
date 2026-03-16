import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken()); // 세로
        int w = Integer.parseInt(st.nextToken()); // 가로

        int[] arr = new int[w];

        int maxHeight = 0;
        int maxIdx = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            if(a > maxHeight) {
                maxHeight = a;
                maxIdx = i;
            }
        }

        // 왼쪽부터 가장 높은거 - 현재위치
        int maxLeft = 0;
        int maxRight = 0;
        int total = 0;
        for(int i=0; i<maxIdx; i++) {
            if(maxLeft < arr[i]) {
                maxLeft = arr[i];
            }
            total += maxLeft - arr[i];
        }

        // 오른쪽부터 가장 높은거 - 현재위치
        for(int i=w-1; i>maxIdx; i--) {
            if(maxRight < arr[i]) {
                maxRight = arr[i];
            }
            total += maxRight - arr[i];
        }
        
        System.out.println(total);
    }
}