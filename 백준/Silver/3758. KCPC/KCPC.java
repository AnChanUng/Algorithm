import java.util.*;
import java.lang.*;
import java.io.*;
/*
    1.1 T(테스트 데이터) 입력 받기
    1.2 n(팀의 개수), k(문제의 개수), t(팀의 ID), m(로그 엔트리 개수) 입력 받기
    1.3 m개의 줄에 i(팀 ID), j(문제 번호), s(획득 점수) 입력 받기
    2.  최종 점수 순으로 순위 매기기
    2.1 최종 점수가 같으면 제출 횟수 적은 팀의 순위가 높음
    2.2 또 같으면 마지막 제출 시간이 더 빠른 팀의 순위가 높음
    3.  팀 순위 출력
*/
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken()); // 팀의 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수

            int[][] arr = new int[n+1][k+1]; 
            int[][] res = new int[n][4];     // 팀ID, 총점, 제출횟수, 마지막 제출
            for(int j=0; j<n; j++) res[j][0] = j + 1;
                
            for(int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 팀 ID
                int b = Integer.parseInt(st.nextToken()); // 문제 번호
                int s = Integer.parseInt(st.nextToken()); // 획득 점수

                int idx = a - 1;

                res[idx][2]++;
                res[idx][3] = j;

                int old = arr[a][b];
                if(s > old) {
                    arr[a][b] = s;
                    res[idx][1] += (s - old);
                }
            }

            // for(int j=0; j<3; j++) {
            //    System.out.println(res[j][0] + " " + res[j][1] + " " + res[j][2] + " " + res[j][3]); 
            // }

            // 점수를 기준으로 내림차순 res[0][1]
            // 같으면 제출 횟수 적은 팀의 순위가 높음 res[0][2] 오름차순
            // 같으면 마지막 제출 시간이 더 빠른 팀의 순위가 높음 res[0][3] 오름차순
            Arrays.sort(res, (x, y) -> {
                if(x[1] != y[1]) {
                    return Integer.compare(y[1], x[1]);
                }
                if(x[2] != y[2]) {
                    return Integer.compare(x[2], y[2]);
                }
                return Integer.compare(x[3], y[3]);
            });
            
            for(int j=0; j<n; j++) {
                if(t == res[j][0]) {
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }
}