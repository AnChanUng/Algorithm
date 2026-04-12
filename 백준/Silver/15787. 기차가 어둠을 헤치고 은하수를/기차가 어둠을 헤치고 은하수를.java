import java.util.*;
import java.lang.*;
import java.io.*;
/*
    1. n개의 배열 만들기 (20칸짜리) -> 기차
    2. 명령어 수행
    3. 1번째 기차부터 은하수 건넘 
       같은 상태의 기차가 있으면 건널 수 없음
    4. 은하수 건넌 기차의 수 출력
*/
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 기차의 수
        int m = Integer.parseInt(st.nextToken()); // 명령의 수        
        
        int[][] arr = new int[n+1][21]; 

        // arr[0][0] == 0은 빈곳 1은 사람
        for(int k=0; k<m; k++) { // 명령
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            
            // 1 i x : i번째 기차에 x번째 좌석에 태우기 || 이미사람타있으면x
            // 2 i x : i번째 기차에 x번째 좌석에 앉은 사람 하차 || 사람없으면 x
            // 3 i x : i번째 기차에 앉아있는 승객들 모두 한칸씩 뒤로 k->k+1
            //         20번째 앉아있는 사람 하차
            // 4 i   : i번째 기차에 앉아있는 승객들 모두 한칸씩 앞으로 k->k-1
            //         1번째 앉아있는 사람 하차
            if(a == 1) {
                int x = Integer.parseInt(st.nextToken());
                if(arr[i][x] == 0) {
                    arr[i][x] = 1; // 승차
                }
            } else if (a == 2) {
                int x = Integer.parseInt(st.nextToken());
                if(arr[i][x] == 1) {
                    arr[i][x] = 0; // 하차
                }
            } else if (a == 3) {
                for(int j=20; j>1; j--) {
                    arr[i][j] = arr[i][j-1];
                }
                arr[i][1] = 0;
            } else if (a == 4) {
                for(int j=1; j<20; j++) {
                    arr[i][j] = arr[i][j+1];
                }
                arr[i][20] = 0;
            }
        }  
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            boolean flag = true;
            for(int j=1; j<i; j++) {
                if(isSame(arr[i], arr[j])) {
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }
        System.out.print(cnt);
    }
    static boolean isSame(int[] a, int[] b) {
        for(int k=1; k<=20; k++) {
            if(a[k] != b[k]) {
                return false;
            }
        }
        return true;
    }
}