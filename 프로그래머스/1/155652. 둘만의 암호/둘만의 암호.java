class Solution {
    public String solution(String s, String skip, int index) {
        
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            char idx = s.charAt(i);
            for(int j=0; j<index; j++) {
                idx++;
                if(idx>'z') { idx -= 26; }
                if(skip.contains(String.valueOf(idx))) { j--; }
            }
            answer += idx;
        }
        return answer;
    }
}