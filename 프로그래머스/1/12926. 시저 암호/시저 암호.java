class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if('a' <= c && c <= 'z') {
                answer += (char)('a' + (c - 'a' + n) % 26);
            } else if ('A' <= c && c <= 'Z') {
                answer += (char)('A' + (c - 'A' + n) % 26);
            } else {
                answer += " ";
            }
        }
        return answer;
    }
}