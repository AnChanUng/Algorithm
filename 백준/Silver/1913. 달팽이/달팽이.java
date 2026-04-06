import java.util.*;
import java.lang.*;
import java.io.*;

class Main { // 위 -> 우 -> 아 -> 좌 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dist;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine()); // 찾으려는

        dist = new int[n][n];

        int x = n / 2;
        int y = n / 2;
        int num = 1;
        int mx = 0;
        int my = 0;

        dist[x][y] = num++;
        if(dist[x][y] == m) {
            mx = x;
            my = y;
        }

        int move = 1;
        int dir = 0;
        while(num <= n*n) {
            for(int t=0; t<2; t++) {
                for(int i=0; i<move; i++) {
                    x += dx[dir];
                    y += dy[dir];
                    if(x < 0 || x >= n || y < 0 || y >= n) break;
                    dist[x][y] = num++;
                    if(dist[x][y] == m) {
                        mx = x;
                        my = y;
                    }
                }
                dir = (dir + 1) % 4;
            }
            move++;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println((mx + 1) + " " + (my + 1));
    }
}