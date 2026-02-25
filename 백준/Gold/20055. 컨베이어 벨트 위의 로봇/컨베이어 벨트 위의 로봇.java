import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int step = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        // 내구도 입력받기
        int[] belt = new int[2*n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robot = new boolean[n];

        while(true) {
            // 1. 벨트 회전
            step++;
            int last = belt[2 * n - 1];
            for(int i=2*n-1; i>=1; i--) {
                belt[i] = belt[i-1];
            }
            belt[0] = last;

            // 2. 로봇 회전
            for(int i=n-1; i>=1; i--) {
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            robot[n-1] = false;

            // 3. 로봇 이동
            for(int i=n-2; i>=0; i--) {
                if(robot[i] && !robot[i+1] && belt[i+1] > 0) {
                    robot[i] = false;
                    robot[i+1] = true;
                    belt[i+1]--;
                }
            }
            robot[n-1] = false;

            // 4.로봇 올리기
            if(belt[0] > 0 && !robot[0]) {
                robot[0] = true;
                belt[0]--;
            }

            //. 5. 내구도 0개수 세기 k이상이면 break
            int zeroCnt = 0;
            for(int i=0; i<2*n; i++) {
                if(belt[i] == 0) {
                    zeroCnt++;
                }
            }
            if(zeroCnt >= k) break;
        }
        System.out.println(step);
    }
}