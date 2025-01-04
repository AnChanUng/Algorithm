import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        
        long answer = 0;
        
        String s = String.valueOf(n);
        Integer[] arr = new Integer[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        
        answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}