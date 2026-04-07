import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); // 회전수

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++) {
          st = new StringTokenizer(br.readLine());
          for(int j=0; j<m; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
          }
        }

        for(int s=0; s<Math.min(n, m) / 2; s++) {
          for(int rot=0; rot<r; rot++) {
            int temp = arr[s][s];
            // 맨위
            for(int i=s; i<m-1-s; i++) {
              arr[s][i] = arr[s][i+1];
            }

            // 맨오른쪽
            for(int i=s; i<n-1-s; i++) {
              arr[i][m-1-s] = arr[i+1][m-1-s];
            }

            // 맨아래
            for(int i=m-1-s; i>s; i--) {
              arr[n-s-1][i] = arr[n-s-1][i-1];
            }

            // 맨왼쪽
            for(int i=n-1-s; i>s+1; i--) {
              arr[i][s] = arr[i-1][s];
            }
            arr[s+1][s] = temp;
          }
        }
       
        for(int i=0; i<n; i++) {
          for(int j=0; j<m; j++) {
            System.out.print(arr[i][j] + " ");
          }
          System.out.println();
        }
    }
}