import java.io.IOException;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 6이 연속 3번 들어가는 수를 찾고 cnt++;
        int ans = 0;
        int arr[] = new int[10001];
        int num = 1;
        while(ans < 10000) {
            int cnt = 0;
            String strNum = String.valueOf(num);
            boolean flag = false;
            for(int i=0; i<strNum.length(); i++) {
                if(strNum.charAt(i) == '6') {
                    cnt++;
                } else {
                    cnt = 0;
                }

                if(cnt >= 3) {
                    ans++;
                    arr[ans] = num;
                    flag = true;
                    break;
                }
            }
            num++;
        }

        System.out.print(arr[n]);
    }
}