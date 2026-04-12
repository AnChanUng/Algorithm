import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[][] arr = new int[5][5];
        int[][] res = new int[5][5];
        boolean[][] vis = new boolean[5][5];
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                res[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로, 세로, 대각선 5개가 true면 대각선++
        // 대각선==3 빙고, 대각선이 3개가 되는 순간의 인덱스 출력
        flag = false;
        int idx = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                idx++;
                for(int a=0; a<5; a++) {
                    for(int b=0; b<5; b++) {
                        if(arr[a][b] == res[i][j]) {
                            arr[a][b] = 0;
                        }
                        bingo(arr);
                        if(flag) {
                            System.out.println(idx);
                            return;
                        }
                    }
                }
            }
        }
    }
    static void bingo(int[][] arr) {
        int cnt = 0;
        for(int i=0; i<5; i++) {
            if(arr[i][0] == 0 && arr[i][1] == 0 && arr[i][2] == 0 && arr[i][3] == 0 && arr[i][4] == 0) cnt++;
            if(arr[0][i] == 0 && arr[1][i] == 0 && arr[2][i] == 0 && arr[3][i] == 0 && arr[4][i] == 0) cnt++;
        }
        if(arr[0][0] == 0 && arr[1][1] == 0 && arr[2][2] == 0 && arr[3][3] == 0 && arr[4][4] == 0) cnt++;
        if(arr[0][4] == 0 && arr[1][3] == 0 && arr[2][2] == 0 && arr[3][1] == 0 && arr[4][0] == 0) cnt++;

        if(cnt >= 3) {
            flag = true;
        }
    }
}