import java.io.IOException;
import java.util.Scanner;
/*
    3kg or 5kg을 선택해 n킬로그램을 만들고 하나 선택할 때마다 한개씩 카운트

    문제
    1. n 입력 받기
    2. while(n != 0)
    2.1 - n을 5로 나눔 cnt++
    2.2 - n - 3 cnt++
    3. 선택 개수(cnt) 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        while(n >= 0) {
            if(n % 5 == 0) {
                cnt += n/5;
                System.out.println(cnt);
                return;
            } else {
                n -= 3;
                cnt++;
            }
        }
        System.out.println(-1);
    }
}