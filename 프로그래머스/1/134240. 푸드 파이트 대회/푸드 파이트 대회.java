class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<food.length; i++) {
            int number = food[i]/2;
            
            for(int j=0; j<number; j++) {
                sb.append(i);
            }
        }
        
        String left = sb.toString();
        String right = sb.reverse().toString();
        
        StringBuilder result = new StringBuilder(left);
        result.append("0").append(right);
        
        return result.toString();
    }
}