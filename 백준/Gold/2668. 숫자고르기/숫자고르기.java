import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static boolean[] vis;
    static boolean[] finished;
    static List<Integer> ans = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        vis = new boolean[n+1];
        finished = new boolean[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=n; i++) {
            if(!vis[i]) {
                dfs(i);
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for(int x : ans) System.out.println(x);
    }

    static void dfs(int cur) {
        vis[cur] = true;
        int next = arr[cur];

        if(!vis[next]) {
            dfs(next);
        } else if (!finished[next]) {
            while(next != cur) {
                ans.add(next);
                next = arr[next];
            }
            ans.add(cur);
        }
        finished[cur] = true;
    }
}