import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            q.offer(i);
        }

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