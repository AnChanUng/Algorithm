import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int x = lcm(b, d);
        int num = a * (x / b) + c * (x/d);
        int g = gcd(num, x);
        
        StringBuilder sb = new StringBuilder();
        sb.append(num/g).append(" ").append(x/g);
        System.out.println(sb);
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