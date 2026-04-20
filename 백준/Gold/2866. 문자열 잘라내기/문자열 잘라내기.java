import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int r, c;
    static char[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // 행의 개수
        c = Integer.parseInt(st.nextToken()); // 열의 개수

        arr = new char[r][c];
        for(int i=0; i<r; i++) {
            String str = br.readLine();
            for(int j=0; j<c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int lo = 0;
        int hi = r-1;
        int ans = 0;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(check(mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(ans);   
    }
    static boolean check(int k) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<c; i++) { // 6
            StringBuilder sb = new StringBuilder();
            for(int j=k; j<r; j++) { // 2
                sb.append(arr[j][i]);
            }
            if(set.contains(sb.toString())) {
                return false;
            } else { // 없으면 add
                set.add(sb.toString());
            }
        }
        return true;
    }
}