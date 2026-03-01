import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            while(!stack.empty() && stack.peek()[0] <= arr[i]) {
                stack.pop();
            }
            if(!stack.empty()) {
                res[i] = stack.peek()[1];
            } else {
                res[i] = 0;
            }
            stack.add(new int[]{arr[i], i+1});
        }

        for(int i=0; i<n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}