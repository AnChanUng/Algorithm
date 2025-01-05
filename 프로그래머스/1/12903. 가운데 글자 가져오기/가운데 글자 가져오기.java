class Solution {
    public String solution(String s) {
        String answer = "";
       
        if (s.length() % 2 == 1) {
            char a = s.charAt(s.length()/2);
            answer += a;
        } else {
            char b = s.charAt(s.length()/2-1);
            char c = s.charAt(s.length()/2);
            answer += b;
            answer += c;
        }
        
        return answer;
    }
}