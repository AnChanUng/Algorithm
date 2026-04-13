import java.util.*;
import java.lang.*;
import java.io.*;
/*
        1.상하 반전
        2.좌우 반전
        3.시계방향 90도 회전
        4.반시계방향 90도 회전
        5.n/2 * m/2 4개의 부분 배열로 나누고
          1->2->3->4->1로 이동
        6.1->4->3->2->1
*/
class Main {
    static int n, m, r, operNum;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // 연산의 수

        arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while(r > 0) {
           int operNum = Integer.parseInt(st.nextToken());
           if(operNum == 1) {
                op1();
            } else if (operNum == 2) {
                op2();
            } else if (operNum == 3) {
                op3();
            } else if (operNum == 4) {
                op4();
            } else if (operNum == 5) {
                op5();
            } else if (operNum == 6) {
                op6();
            }
            r--;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void op1() {
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<m; j++) {
                int prev1 = arr[i][j];
                arr[i][j] = arr[n-i-1][j];
                arr[n-i-1][j] = prev1;
            }
        }
    }
    static void op2() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m/2; j++) {
                int prev2 = arr[i][j];
                arr[i][j] = arr[i][m-1-j];
                arr[i][m-1-j] = prev2;
            }
        }
    }
    static void op3() {
        int[][] res = new int[m][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                res[j][n-1-i] = arr[i][j];
            }
        }
        arr = res;
        int tmp = n;
        n = m;
        m = tmp;
    }
    static void op4() {
        int[][] res = new int[m][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                res[m-1-j][i] = arr[i][j];
            }
        }
        arr = res;
        int tmp = n;
        n = m;
        m = tmp;
    }
    static void op5() {
        int[][] newArr = new int[n][m];
        int halfN = n / 2;
        int halfM = m / 2;
        
        for (int i=0; i<halfN; i++) {
            for (int j=0; j<halfM; j++) {
                // 1 → 2: 부분1 (i, j) → 부분2 자리 (i, j + halfM)
                newArr[i][j + halfM] = arr[i][j];
                
                // 2 → 3: 부분2 (i, j + halfM) → 부분3 자리 (i + halfN, j + halfM)
                newArr[i + halfN][j + halfM] = arr[i][j + halfM];
                
                // 3 → 4: 부분3 (i + halfN, j + halfM) → 부분4 자리 (i + halfN, j)
                newArr[i + halfN][j] = arr[i + halfN][j + halfM];
                
                // 4 → 1: 부분4 (i + halfN, j) → 부분1 자리 (i, j)
                newArr[i][j] = arr[i + halfN][j];
            }
        }
        arr = newArr;
    }
    static void op6() {
        int[][] newArr = new int[n][m];
        int halfN = n / 2;
        int halfM = m / 2;
        
        for (int i=0; i<halfN; i++) {
            for (int j=0; j<halfM; j++) {
            // 1 → 4: 부분1 (i, j) → 부분4 자리 (i + halfN, j)
            newArr[i + halfN][j] = arr[i][j];
                
            // 2 → 1: 부분2 (i, j + halfM) → 부분1 자리 (i, j)
            newArr[i][j] = arr[i][j + halfM];
                
            // 3 → 2: 부분3 (i + halfN, j + halfM) → 부분2 자리 (i, j + halfM)
            newArr[i][j + halfM] = arr[i + halfN][j + halfM];
                
            // 4 → 3: 부분4 (i + halfN, j) → 부분3 자리 (i + halfN, j + halfM)
            newArr[i + halfN][j + halfM] = arr[i + halfN][j];
            }
        }
        arr = newArr;
    }
}