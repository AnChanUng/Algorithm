import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push")) {
                stack.push(Integer.parseInt(str[1]));
            } else if (str[0].equals("pop")) {
                if(!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            } else if (str[0].equals("size")) {
                System.out.println(stack.size());
            } else if (str[0].equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (str[0].equals("top")) {
                if(!stack.isEmpty()) { 
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}