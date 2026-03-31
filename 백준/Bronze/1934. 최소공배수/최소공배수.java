import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = lcm(x, y); // 최소공배수
            System.out.println(result);
        }
    }
    static int lcm(int a, int b) { // 최소공배수
        return a / gcd(a, b) * b;
    }
    
    static int gcd(int a, int b) { // 최대공약수
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}