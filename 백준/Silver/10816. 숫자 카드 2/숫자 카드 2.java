import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m, a, b;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a = Integer.parseInt(st.nextToken());
            if(map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            b = Integer.parseInt(st.nextToken());
            if(map.containsKey(b)) {
                sb.append(map.get(b)).append(" ");                                                                                                                                                                                                                                                                                                                                                                                                                             
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.print(sb);
    }
}