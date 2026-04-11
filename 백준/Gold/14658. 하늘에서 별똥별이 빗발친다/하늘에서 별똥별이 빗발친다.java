import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        int l = Integer.parseInt(st.nextToken()); // 트램펄린 한변의 길이
        int k = Integer.parseInt(st.nextToken()); // 별똥별의 수

        int[] xs = new int[k];
        int[] ys = new int[k];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxCatch = 0;
        for(int i=0; i<k; i++) {
            for(int j=0; j<k; j++) {
                int x1 = xs[i];
                int y1 = ys[j];
                int x2 = x1 + l;
                int y2 = y1 + l;
                int cnt = 0;
                for(int a=0; a<k; a++) {
                    if(xs[a] >= x1 && xs[a] <= x2 && ys[a] >= y1 && ys[a] <= y2) {
                        cnt++;
                    }
                }
                maxCatch = Math.max(maxCatch, cnt);
            }
        }
        System.out.println(k - maxCatch);
    }
}