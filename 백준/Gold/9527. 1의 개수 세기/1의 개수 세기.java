import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        long x = f(b) - f(a-1);
        System.out.println(x);
    }
    static long f(long n) {
        if (n <= 0) return 0;
        long sum = 0;
        for(long k=0; k<55; k++) {
            long period = 1L << (k+1);
            long half = 1L << k;
            long full = (n + 1) / period;
            long rem = (n + 1) % period;
            long cnt = full * half + Math.max(0L, rem - half);
            sum += cnt;
        }
        return sum;
    }
}