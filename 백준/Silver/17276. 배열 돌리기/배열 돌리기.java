import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test=0; test<t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 배열의 크기
            int d = Integer.parseInt(st.nextToken()); // 각도
            // 각도가 양수면 시계방향 음수면 반시계방향
            int[][] arr = new int[n][n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] res = new int[n][n];
            
            // 음수 → 양수로 변환 (-45도 = 시계 315도)
            int rot = ((d % 360) + 360) % 360 / 45;
            
            for(int r=0; r<rot; r++) {
                for(int i=0; i<n; i++) {
                    res[i] = arr[i].clone();
                }
                
                for(int i=0; i<n; i++) {
                    res[i][n/2]   = arr[i][i];     // 주 대각선 → 가운데 열
                    res[i][n-1-i] = arr[i][n/2];   // 가운데 열 → 부 대각선
                    res[n/2][i]   = arr[n-1-i][i]; // 부 대각선 → 가운데 행 ← 수정!
                    res[i][i]     = arr[n/2][i];   // 가운데 행 → 주 대각선
                }
                
                for(int i=0; i<n; i++) {
                    arr[i] = res[i].clone();
                }
            }
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}