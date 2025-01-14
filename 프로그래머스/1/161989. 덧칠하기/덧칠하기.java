class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int number = 0;
        
        for(int i=0; i<section.length; i++) {
            if (section[i] > number) {
                number = section[i] + m - 1;
                answer += 1;
            }
        }
        
        return answer;
    }
}