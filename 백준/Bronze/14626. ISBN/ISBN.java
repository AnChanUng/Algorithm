import java.util.Scanner;
/*
    str[i]가 짝수면 1을 곱하고 i가 홀수면 3을 곱함 그 값을 10으로 나눈 나머지가 0이 되도록 한다
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int total = 0;
        int index = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '*') {
                index = i;
                continue;
            }
            int n = str.charAt(i) - '0';
            if(i % 2 == 0) {
                total += n * 1;
            } else {
                total += n * 3;
            }
        }

        for(int i=0; i<=9; i++) {
            if(index % 2 == 0) {
                if ((total + i) % 10 == 0) {
                    System.out.print(i);
                    break;
                }
            } else {
                if((total + i * 3) % 10 == 0) {
                    System.out.print(i);
                    break;
                }
            }
        }
    }
}