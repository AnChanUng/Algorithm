import java.util.*;
class Solution {
    static int maxLen;
    public int solution(String s) {
        maxLen = 1;

        int n = s.length();
        int idx = n;
        while(idx > 1) {
            boolean flag = false;
            for(int i=0; i<n-idx+1; i++) {
                if(isPalindrome(s, i, i+idx-1)) { 
                    maxLen = idx;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
            idx--;
        }

        return maxLen;
    }
    static boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}