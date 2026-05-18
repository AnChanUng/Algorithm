import java.util.*;
import java.io.*;
/*
    1. n개의 배열 만들기
    2. 배열에서 m*m의 합이 가장 큰 것 출력

    알고리즘: 누적합
*/
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxSum = 0;
            for(int i=0; i<n-m+1; i++) {
                for(int j=0; j<n-m+1; j++) {
                    int sum = 0;
                    for (int a=0; a<m; a++) {
                        for(int b=0; b<m; b++) {
                            sum += arr[i+a][j+b];
                        }
                    }
                    maxSum = Math.max(maxSum, sum);
                }
            }
            System.out.println("#" + test_case + " " + maxSum);
        }
    }
}