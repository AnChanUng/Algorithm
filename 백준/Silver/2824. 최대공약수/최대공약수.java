import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = BigInteger.ONE;
        for(int i=0; i<n; i++) {
            BigInteger b = new BigInteger(st.nextToken());
            a = a.multiply(b);
        }
        int m = Integer.parseInt(br.readLine());
        BigInteger c = BigInteger.ONE;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            BigInteger d = new BigInteger(st.nextToken());
            c = c.multiply(d);
        }
        BigInteger x = a.gcd(c);
        BigInteger limit = new BigInteger("100000000");
        if(x.compareTo(limit) >= 0) {
            String str = x.toString();
            String tmp = str.substring(str.length()-9);
            System.out.println(tmp);
        } else {
            System.out.println(x);
        }
    }
}