import java.util.Arrays;

class Solution {
    public String solution(String s) {
        
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        
        String answer = new String(charArr);
        String result = new StringBuilder(answer).reverse().toString();
        
        return result;
    }
}