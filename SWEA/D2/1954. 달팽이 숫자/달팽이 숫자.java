import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            int x = 0;
            int y = 0;
            int dir = 3;
            for(int i=1; i<=n*n; i++) {
                arr[x][y] = i;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                    dir = (dir + 3) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }

            System.out.println("#" + test_case);
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}