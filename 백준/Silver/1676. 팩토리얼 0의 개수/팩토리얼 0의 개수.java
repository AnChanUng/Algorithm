import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        BigInteger result = BigInteger.ONE;
        for(int i=n; i>0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        String str = result.toString();
        int cnt = 0;
        for(int i=str.length()-1; i>0; i--) {
            if(str.charAt(i) == '0') {
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}