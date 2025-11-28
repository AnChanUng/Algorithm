import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int idx=0;
        int i=1;
        while(idx < n) {
            if(!stack.isEmpty() && arr[idx] == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            } else {
                stack.push(i);
                sb.append("+").append("\n");
                i++;
            }

            if(i > n*10) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}