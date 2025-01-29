import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i=0; i<t; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<str.length(); j++) {
                char a = str.charAt(j);
                
                if(a == '(') {
                    stack.push(a);
                } else if (a == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(a);
                    }
                }
            }

            if(!stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

            stack.clear();
        }
    }
}