import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long g = Long.parseLong(st.nextToken()); 
        long l = Long.parseLong(st.nextToken()); 

        long n = l / g;  // x * y = n, gcd(x, y) = 1
        long ansX = 1, ansY = n;
        
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0 && gcd(i, n / i) == 1) {
                ansX = i;       
                ansY = n / i;
            }
        }
        System.out.println((ansX * g) + " " + (ansY * g));
    }
    static long gcd(long a, long b) { // 최대공약수
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}