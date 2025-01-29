import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(!q.isEmpty()) {
            for(int i=0; i<k-1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll());

            if(!q.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");

        System.out.println(sb.toString());
    }
}