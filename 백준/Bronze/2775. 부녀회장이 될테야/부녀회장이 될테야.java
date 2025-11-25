import java.io.IOException;
import java.util.Scanner;
/*
    모든 아파트에 사는 사람들의 수의 합 구하기

    문제
    1.1 테스트 케이스 수(t) 입력 받기
    1.2 k 입력 받기
    1.3 n 입력 받기
    2   a층의 b호에 살려면
    자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다

 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int a=0; a<t; a++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int dp[][] = new int [k+1][n+1];

            // 0층 초기화
            for(int i=1; i<=n; i++) {
                dp[0][i] = i;
            }

            for(int i=1; i<=k; i++) {
                dp[i][1] = 1;
                for(int j=2; j<=n; j++) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}