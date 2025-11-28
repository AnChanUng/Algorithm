import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        StringBuilder sb = new StringBuilder();
        for(int num=m; num<=n; num++) {
            if(isPrime(num)) {
                sb.append(num).append("\n");
            }
        }
        System.out.print(sb);
    }

    static boolean isPrime(int x) {
        if(x < 2) {
            return false;
        }
        for(int i=2; i<=Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}