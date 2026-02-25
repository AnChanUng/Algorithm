import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while(a != b) {
            if(b < a) {
                System.out.print(-1);
                return;
            }
            if(b % 2 == 0) {
                b /= 2;
            } else if(b % 10 == 1) {
                b = (b - 1) / 10;
            } else {
                System.out.print(-1);
                return;
            }
            cnt++;
        }
        System.out.print(cnt);
    }
}