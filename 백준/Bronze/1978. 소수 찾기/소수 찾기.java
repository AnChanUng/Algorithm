import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean isPrime(int x) {
        if(x == 1) {
            return false;
        }
        if(x == 2) {
            return true;
        }
        for(int i=2; i<=(int)Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(isPrime(a)) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}