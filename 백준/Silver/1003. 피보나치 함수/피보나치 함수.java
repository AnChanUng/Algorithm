import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int a=0; a<t; a++) {
            int n = sc.nextInt();

            int[][] dp = new int[41][2];

            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
            for(int i=2; i<=40; i++) {
                for(int j=0; j<2; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i-2][j];
                }
            }
            
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}