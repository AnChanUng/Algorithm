class Solution {
    public int solution(String s) {
        
        int answer = 0;
        int count = 0;
        char x = s.charAt(0);
        
        for(int i=0; i<s.length(); i++) {
            if (count == 0) {
                answer++;
                x = s.charAt(i);
            }
            
            if(s.charAt(i) == x) {
                count++;
            } else {
                count--;
            }
        }

        return answer;
    }
}