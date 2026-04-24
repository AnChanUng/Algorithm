import java.util.*;
import java.io.*;
/* 
   배열에서 6개를 골라 모든 경우의 수 출력

   알고리즘: 조합 dfs
*/
public class Main {
    static int k;
    static int[] arr;
    static int[] res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            
            arr = new int[k];
            res = new int[k];
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
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<k; i++) {
            res[depth] = arr[i];
            dfs(i+1, depth+1);
        }
    }
}