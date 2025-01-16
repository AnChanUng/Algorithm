class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        for(char ch : myString.toCharArray()) {
            if(ch == 'A') {
                sb.append('B');
            } else if(ch == 'B') {
                sb.append('A');
            }
        }
         
        if (sb.toString().contains(pat)) {
            return 1;
        } else {
            return 0;
        }
    }
}