import java.util.*;
import java.io.*;
/* 중복X 수열 */
class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        dfs(0, 1);
    }

    static void dfs(int depth, int start) {
        if(depth == m) {
            for(int i=0; i<m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<=n; i++) {
            arr[depth] = i;
            dfs(depth+1, i+1);
        }
    }
}