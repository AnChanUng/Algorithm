import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int gcd(int x, int y) {
        while(y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int g = gcd(a, b);
        int l = a * b / g;

        System.out.println(g);
        System.out.println(l);
    }
}