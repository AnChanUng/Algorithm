class Solution {
    public int solution(long num) {
        int cnt = 0;
        
        while(num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            cnt++;
            
            if (cnt >= 500) {
                cnt = -1;
                break;
            }
        }
        
        return cnt;
    }
}