import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    static int[] dy = {1, 0, -1, 0}; // 우 상 좌 하
    static int[] dx = {0, -1, 0, 1}; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken()); // 가장 왼쪽 위 칸
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken()); // 가장 오른쪽 아래 칸
        int c2 = Integer.parseInt(st.nextToken());
        
        int n = r2-r1+1;
        int m = c2-c1+1;
        int[][] dist = new int[n][m];
        int filled = 0;

        int x = 0;
        int y = 0;
        int num = 1;
        int move = 1;
        int dir = 0;

        if(x >= r1 && x <= r2 && y >= c1 && y <= c2) {
            dist[x-r1][y-c1] = num;
            filled++;
        }
        
        while(filled < n*m) {
            for(int t=0; t<2; t++) {
                for(int i=0; i<move; i++) {
                    x += dx[dir];
                    y += dy[dir];
                    num++;
                    if(x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                        dist[x-r1][y-c1] = num;
                        filled++;
                    }
                    if(filled >= n * m) break;
                }
                dir = (dir+1) % 4;
                if(filled >= n*m) break;
            }
            move++;
        }

       // 오른쪽 정렬을 위한 최대 자릿수 계산
        int maxVal = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                maxVal = Math.max(maxVal, dist[i][j]);
        int width = String.valueOf(maxVal).length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) sb.append(' ');
                sb.append(String.format("%" + width + "d", dist[i][j]));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}