import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        String str = "";
        StringBuilder sb = new StringBuilder();
        for(int i=my_string.length()-1; i>=0; i--) {
            sb.insert(0, my_string.charAt(i));
            System.out.println("sb:" + sb.toString());
            answer[i] = sb.toString();
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}