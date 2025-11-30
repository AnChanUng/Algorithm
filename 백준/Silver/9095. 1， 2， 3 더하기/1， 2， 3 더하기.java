import java.util.Scanner;

public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int t=0; t<test_case; t++) {
            int n = sc.nextInt();

            dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i=4; i<=n; i++) {
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }

            System.out.println(dp[n]);
        }
    }
}