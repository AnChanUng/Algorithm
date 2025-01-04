class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String s = String.valueOf(x);
        int number = 0;
        // 각 자리수 더하기
        for(int i=0; i<s.length(); i++) {
            number += s.charAt(i) - '0';
        }
        // x에서 각 자리 더 한수 나눠지면 하샤드
        if(x % number != 0) {
            answer = false;
        }
            
        return answer;
    }
}