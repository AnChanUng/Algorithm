import java.util.*;
import java.lang.*;
import java.io.*;
/*
  티셔츠는 남아도 되지만 부족해서는 x
  펜은 남거나 부족해서는 안되고 정확한 참가자 수만큼 준비
*/
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int xl = Integer.parseInt(st.nextToken());
        int xxl = Integer.parseInt(st.nextToken());
        int xxxl = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()); // 정수 티셔츠
        int p = Integer.parseInt(st.nextToken()); // 펜
        
        int cnt = 0;
        if(s%t == 0) {
            cnt += s/t;
        } else {
            cnt += s / t + 1;
        }
        if(m%t == 0) {
            cnt += m / t;
        } else {
            cnt += m / t + 1;
        }
        if(l%t == 0) {
            cnt += l / t;
        } else {
            cnt += l / t + 1;
        }
        if(xl%t == 0) {
            cnt += xl / t;
        } else {
            cnt += xl / t + 1;
        }
        if(xxl%t == 0) {
            cnt += xxl / t;
        } else {
            cnt += xxl / t + 1;
        }
        if(xxxl%t == 0) {
            cnt += xxxl / t;
        } else {
            cnt += xxxl / t + 1;
        }
        
        int a = n / p;
        int b = n % p;

        System.out.println(cnt);
        System.out.println(a + " " + b);
    }
}