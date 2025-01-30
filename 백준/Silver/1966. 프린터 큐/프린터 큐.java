import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            
            for(int j=0; j<n; j++) {
                int level = Integer.parseInt(st2.nextToken());
                q.offer(new int[]{j, level});
            }

            int prior = 0;
            
            while(!q.isEmpty()) {
                int[] current = q.poll();
                boolean isPrint = true;

                for(int[] a : q) {
                    if(a[1] > current[1]) {
                        isPrint = false;
                        break;
                    }
                }

                if(isPrint) {
                    prior++;
                    if(current[0] == m) {
                        System.out.println(prior);
                        break;
                    }
                } else {
                    q.offer(current);
                }
            }
        }
    }
}