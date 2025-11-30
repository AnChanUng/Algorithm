import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt();
        for(int t=0; t<test_case; t++) {
            int n = sc.nextInt();
            long[] p = new long[101];
            p[0] = 0;
            p[1] = 1;
            p[2] = 1;
            p[3] = 1;
            p[4] = 2;
            for(int i=5; i<=n; i++) {
                p[i] = p[i-2] + p[i-3];
            }
            System.out.println(p[n]);
        }
    }
}