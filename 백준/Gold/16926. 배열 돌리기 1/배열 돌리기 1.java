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

        for(int s=0; s<Math.min(n,m)/2; s++) {
          for(int rot=0; rot<r; rot++) {
            int temp = arr[s][s];  // (0,0) 백업
            // 1. 위쪽 변: (s,s) ← (s,s+1) ← ... ← (s, m-1-s)
            for(int j=s; j<m-1-s; j++)
                arr[s][j] = arr[s][j+1];
            // 2. 오른쪽 변: (s, m-1-s) ← (s+1, m-1-s) ← ... ← (n-1-s, m-1-s)
            for(int i=s; i<n-1-s; i++)
                arr[i][m-1-s] = arr[i+1][m-1-s];
            // 3. 아래쪽 변: (n-1-s, m-1-s) ← (n-1-s, m-2-s) ← ... ← (n-1-s, s)
            for(int j=m-1-s; j>s; j--)
                arr[n-1-s][j] = arr[n-1-s][j-1];
            // 4. 왼쪽 변: (n-1-s, s) ← (n-2-s, s) ← ... ← (s+1, s)
            for(int i=n-1-s; i>s+1; i--)
                arr[i][s] = arr[i-1][s];
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