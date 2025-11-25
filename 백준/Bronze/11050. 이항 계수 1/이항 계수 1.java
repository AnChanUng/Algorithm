import java.util.Scanner;

public class Main {
    public static void factorial(int a, int b) {
        int result = 1;
        int denom = 1;
        for(int i=a; i>a-b; i--) {
            result *= i;
        }
        for(int i=1; i<=b; i++) {
            denom *= i;
        }
        int answer = result / denom;
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        factorial(n, k);
    }
}