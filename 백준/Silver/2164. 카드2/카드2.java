import java.util.*;
import java.lang.*;
import java.io.*;

class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1; i<=n; i++) {
            q.add(i);
        }

        while(q.size() > 1) {
            q.poll();
            q.add(q.remove());
        }

        for(int a : q) {
            System.out.print(a);
        }
    }
}