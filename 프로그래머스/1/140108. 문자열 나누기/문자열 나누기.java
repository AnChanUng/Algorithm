class Solution {
    public int solution(String s) {
        
        int answer = 0;
        int[] count = {0, 0};
        char x = s.charAt(0);
        
        for(int i=0; i<s.length(); i++) {
            if (count[0] == count[1]) {
                answer += 1;
                x = s.charAt(i);
            }
            
            if(s.charAt(i) == x) {
                count[0] += 1;
            } else {
                count[1] += 1;
            }
            
        }

        return answer;
    }
}