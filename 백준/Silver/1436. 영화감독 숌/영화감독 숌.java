import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수
    ex) 666 -> 1666 -> 2666

    문제
    1. n 입력 받기
    2. 6이 연속 3번 들어가는 수를 찾고 cnt++;
    3. n일때 종말의 수 출력

    접근 방식
    - 모든 조합 완전 탐색
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int cnt = 1;

        while(cnt != n) {
            num++;
            if(String.valueOf(num).contains("666")) {
                cnt++;
            }
        }
        System.out.println(num);
    }
}