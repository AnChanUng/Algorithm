import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] arr;
    static int[] selected;
    static int k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            
            if(k == 0) break;
            arr = new int[k];
            selected = new int[6];
            
            for(int i=0; i<k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            System.out.println();
        }
    }
    static void dfs(int start, int depth) {
        if(depth == 6) {
            for(int i=0; i<6; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<arr.length; i++) {
            selected[depth] = arr[i];
            dfs(i+1, depth+1);
        }
    }
}