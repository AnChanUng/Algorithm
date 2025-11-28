import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            String[] Inputs = br.readLine().split(" ");
            if(Inputs[0].equals("push")) {
                stack.push(Integer.valueOf(Inputs[1]));
            } else if (Inputs[0].equals("pop")) {
                if(!stack.isEmpty()) {
                    System.out.println(stack.peek());
                    stack.pop();
                } else {
                    System.out.println(-1);
                }
            } else if (Inputs[0].equals("size")) {
                System.out.println(stack.size());
            } else if (Inputs[0].equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (Inputs[0].equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}