import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    0을 부르면 가장 마지막 수를 지움
    배열에 있는 수 합
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<k; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }
        int total = 0;
        while(!stack.empty()) {
            total += stack.peek();
            stack.pop();
        }
        System.out.println(total);
    }
}