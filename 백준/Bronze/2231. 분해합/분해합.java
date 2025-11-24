import java.util.Scanner;

/*
    분해합: N과 N을 이루는 각 자리수의 합
    ex) 245의 분해합: 245 + 2 + 4 + 5
    245는 256의 생성자

    문제
    1. n 입력 받기
    2. n + n[0] ~ [n자리수-1] 더하기
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int total = 0;
        int answer = 0;
        for(int num=0; num<n; num++) {
            String strNum = String.valueOf(num);
            for(int i=0; i<strNum.length(); i++) {
                total += strNum.charAt(i) - '0';
            }
            total += num;
            if(total == n) {
                answer = num;
                break;
            }
            total = 0;
        }

        System.out.print(answer);
    }
}