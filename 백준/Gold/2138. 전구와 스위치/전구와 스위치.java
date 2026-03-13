import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] res = new int[n];
        
        // 전구의 현재 상태
        String a = br.readLine();
        for(int i=0; i<n; i++) {
            arr[i] = a.charAt(i) - '0';
        }
        
        // 우리가 만들고자 하는 상태
        String b = br.readLine();
        for(int i=0; i<n; i++) {
            res[i] = b.charAt(i) - '0';
        }

        int case1 = simulate(arr, res, false);
        int case2 = simulate(arr, res, true);
        
        int ans = Math.min(case1, case2);
        
        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static int simulate(int[] origin, int[] target, boolean firstPress) {
        int n = origin.length;
        int[] temp = origin.clone();
        int cnt = 0;

        if(firstPress) {
            toggle(temp, 0);
            cnt++;
        }

        for(int i=1; i<n; i++) {
            if(temp[i-1] != target[i-1]) {
                toggle(temp, i);
                cnt++;
            }
        }

        for(int i=0; i<n; i++) {
            if(temp[i] != target[i]) {
                return Integer.MAX_VALUE;
            }
        }
        return cnt;
    }

    static void toggle(int[] arr, int idx) {
        int n = arr.length;

        for(int i=idx-1; i<=idx+1; i++) {
            if(i >= 0 && i < n) {
                arr[i] = 1 - arr[i];
            }
        }
    }
}