import java.util.*;
import java.lang.*;
import java.io.*;
/* 소수 사이 수열의 길이 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test=0; test<t; test++) {
            int k = Integer.parseInt(br.readLine());
            int leftSosu = 0;
            int rightSosu = 0;
            
            if(isPrime(k)) { // 소수라면 0을 출력
                System.out.println(0);
                continue;
            } else { // 합성수 라면
                for(int i=k; i>0; i--) {
                    if(isPrime(i)) {
                        leftSosu = i;
                        //System.out.println("leftSosu: " + leftSosu);
                        break;
                    }
                }
                while(true) {
                    k++;
                    if(isPrime(k)) {
                        rightSosu = k;
                        //System.out.println("rightSosu: " + rightSosu);
                        break;
                    }
                }
            }
            int result = rightSosu - leftSosu;
            System.out.println(result);
        }
    }
    static boolean isPrime(int x) {
        if(x == 2) {
            return true;
        }
        for(int i=2; i*i<=x; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}