import java.util.*;
/*
    양수 n을 k진수로 바꾸고 조건에 맞는 소수의 개수 구하기
*/
class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        transfer(n, k, sb);
        sb.reverse();
        
        String[] inputs = sb.toString().split("0");
        for(int i=0; i<inputs.length; i++) {
            if(inputs[i].equals("")) continue;
            if(isPrime(inputs[i])) { // 소수면
                cnt++;
            }
        }
        return cnt;
    }
    static void transfer(int num, int k, StringBuilder sb) {
        while(num > 0) {
            sb.append(num % k);
            num /= k;
        }
    }
    static boolean isPrime(String str) {
        long num = Long.parseLong(str);
        if(num == 2) return true;
        if(num == 1) return false;
        for(long i=2; i*i<=num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}