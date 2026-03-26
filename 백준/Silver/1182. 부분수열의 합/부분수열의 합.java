import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[] vis;
    static int[] arr;
    static int n, s;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        vis = new boolean[n];
        arr = new int[n];
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr, 0, 0, 0);
        System.out.println(cnt);
    }

    static void dfs(int[] arr, int sum, int depth, int idx) {
        //System.out.println("depth: " + depth + " sum: " + sum + " s: " + s);
        if(idx == n) {
            if(depth != 0 && sum == s) cnt++;
            return;
        }
        dfs(arr, sum+arr[idx], depth+1, idx+1);
        dfs(arr, sum, depth, idx+1);
    }
}