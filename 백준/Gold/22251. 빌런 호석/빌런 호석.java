import java.io.*;
import java.util.*;

class Main {
    static int N, K, P, X;
    static final int[] SEG = {
            0x3F, // 0
            0x06, // 1
            0x5B, // 2
            0x4F, // 3
            0x66, // 4
            0x6D, // 5
            0x7D, // 6
            0x07, // 7
            0x7F, // 8
            0x6F  // 9
    };

    static int[][] diff = new int[10][10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int a = 0; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                diff[a][b] = Integer.bitCount(SEG[a] ^ SEG[b]);
            }
        }

        int[] xDigits = toDigitsK(X);

        int ans = 0;
        for (int floor = 1; floor <= N; floor++) {
            if (floor == X) continue;

            int[] fDigits = toDigitsK(floor);

            int need = 0;
            for (int i = 0; i < K; i++) {
                need += diff[xDigits[i]][fDigits[i]];
                if (need > P) break; // 가지치기
            }

            if (need <= P) ans++;
        }

        System.out.println(ans);
    }

    static int[] toDigitsK(int num) {
        int[] d = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            d[i] = num % 10;
            num /= 10;
        }
        return d;
    }
}