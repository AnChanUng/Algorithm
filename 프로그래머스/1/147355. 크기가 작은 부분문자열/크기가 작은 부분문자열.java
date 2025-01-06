class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i=0; i<t.length()-p.length()+1; i++) {
 
            String str = t.substring(i, i+p.length());
            long number1 = Long.parseLong(str);
            long number2 = Long.parseLong(p);

            if(number1 <= number2) {
                answer++;
            }
        }
        
        return answer;
    }
}