import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int layer = 1;
        int end = 1;
        while(n > end) { 
            end += layer * 6;
            layer++;
        }

        System.out.println(layer);
    }
}