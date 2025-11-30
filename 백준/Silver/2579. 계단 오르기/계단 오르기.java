import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다
    연속된 세 개의 계단을 밟아서는 안된다.
    마지막 계단은 밟아야 한다.

    문제
    1.1 계단의 개수(step) 입력 받기
    1.2 각 계단에 쓰여 있는 점수 입력 받음
    2.  dp[i] = max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i])
    3.  최대 점수 출력

    접근 방식
    - DP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];

        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }
        if(n == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
        for(int i=3; i<n; i++) {
            dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
        }

        System.out.println(dp[n-1]);
    }
}