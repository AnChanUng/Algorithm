import java.util.*;
import java.lang.*;
import java.io.*;
/*
    1. n개의 기차 상태를 int 하나로 (비트마스크)
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
        
        int[] train = new int[n + 1]; // 각 기차 상태를 int 하나로
        int MASK = (1 << 20) - 1;     // 하위 20비트만 유지용 마스크
        
        for(int k=0; k<m; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            
            // 1 i x : x번 좌석 켜기
            // 2 i x : x번 좌석 끄기
            // 3 i   : 뒤로 한 칸 (왼쪽 시프트)
            // 4 i   : 앞으로 한 칸 (오른쪽 시프트)
            if(a == 1) {
                int x = Integer.parseInt(st.nextToken());
                train[i] |= (1 << (x - 1));
            } else if(a == 2) {
                int x = Integer.parseInt(st.nextToken());
                train[i] &= ~(1 << (x - 1));
            } else if(a == 3) {
                train[i] = (train[i] << 1) & MASK;
            } else { // a == 4
                train[i] >>= 1;
            }
        }
        
        Set<Integer> seen = new HashSet<>();
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(!seen.contains(train[i])) {
                seen.add(train[i]);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}