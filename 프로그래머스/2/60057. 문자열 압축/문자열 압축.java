class Solution {
    public int solution(String s) {
        int minLen = s.length();
        
        for(int unit=1; unit<=s.length() / 2; unit++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, unit);
            int count = 1;
            
            for(int i=unit; i<s.length(); i+=unit) {
                int end = Math.min(i+unit, s.length());
                String cur = s.substring(i, end);
                
                if(cur.equals(prev)) {
                    count++;
                } else {
                    if(count > 1) sb.append(count);
                    sb.append(prev);
                    prev = cur;
                    count = 1;
                }
            }
            if(count > 1) sb.append(count);
            sb.append(prev);
            
            minLen = Math.min(minLen, sb.length());
        }
        return minLen;
    }
}