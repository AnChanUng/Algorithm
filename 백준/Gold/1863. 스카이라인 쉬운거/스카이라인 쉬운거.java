import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int answer = 0;        
        for(int test=0; test<n; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                answer++;
            }

            if(!stack.isEmpty() && stack.peek() == y) continue;

            stack.push(y);
        }
        for(int v : stack) {
            if(v == 0) {
                continue;
            }
            answer++;
        }

        System.out.println(answer);
    }
}