import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<k; i++) {
            int number = Integer.parseInt(br.readLine());

            if(number != 0) {
                stack.push(number);
            } else if(!stack.isEmpty() && number == 0) {
                stack.pop();
            }
        }

        int sum = 0;
        for(int a : stack) {
            sum += a;
        }

        System.out.println(sum);
    }
}