import java.util.*;
/*
    0부터 숫자를 n진수로 변경해 m개중에 p번째 숫자들을 출력하기 t까지
*/
class Solution {
    static String answer;
    static int a;
    static StringBuilder sb;
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        a = n;
        
        sb = new StringBuilder();
        sb.append(0);
        for(int i=1; i<t*m+10; i++) {
            trans(i);
        }

        for(int i=0; i<sb.length(); i++) {
            if(i % m == (p-1)) {
                answer += sb.charAt(i);
                if(answer.length() == t) break;
            }
        }
        return answer;
    }
    static void trans(int number) {
        StringBuilder temp = new StringBuilder();
        while(number > 0) {
            int rem = number % a;
            if(rem == 10) { temp.append("A"); }
            else if(rem == 11) { temp.append("B"); }
            else if(rem == 12) { temp.append("C"); }
            else if(rem == 13) { temp.append("D"); }
            else if(rem == 14) { temp.append("E"); }
            else if(rem == 15) { temp.append("F"); }
            else { temp.append(rem); }
            number /= a;
        }
        sb.append(temp.reverse());
    }
}