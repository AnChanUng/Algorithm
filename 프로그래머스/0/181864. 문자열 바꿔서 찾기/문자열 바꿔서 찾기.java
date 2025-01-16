class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i : myString.toCharArray()) {
            if(i == 'A') {
                sb.append('B');
            } else if(i == 'B') {
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