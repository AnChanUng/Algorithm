class Solution {
    public int solution(String my_string, String is_suffix) {
        
        StringBuilder sb = new StringBuilder();
        for(int i=my_string.length()-1; i>=0; i--) {
            sb.insert(0, my_string.charAt(i));
            if(sb.toString().equals(is_suffix)) {
                return 1;
            }
        }
        
        return 0;
    }
}