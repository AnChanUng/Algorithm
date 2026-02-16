import java.util.*;
import java.lang.*;
import java.io.*;
/*
  티셔츠는 남아도 되지만 부족해서는 x
  펜은 남거나 부족해서는 안되고 정확한 참가자 수만큼 준비
*/
class Main {
    static int n, t, p;
    static int cnt = 0;
    static int a = 0;
    static int b = 0;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[6];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken()); // 정수 티셔츠
        p = Integer.parseInt(st.nextToken()); // 펜
        
        cnt = 0;
        for(int i=0; i<6; i++) {
            if(arr[i] % t == 0) {
                cnt += arr[i] / t;
            } else {
                cnt += arr[i] / t + 1;
            }
        }
       
        a = n / p;
        b = n % p;

        System.out.println(cnt);
        System.out.println(a + " " + b);
    }
}