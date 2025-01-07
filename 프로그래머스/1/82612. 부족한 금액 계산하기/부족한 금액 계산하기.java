class Solution {
    public long solution(int price, int money, int count) {
        
        long total = 0; // 놀이기구 이용 금액
        for(int i=1; i<=count; i++) {
            total += (long) i * price;
        }
        
        long result = total - money;
        
        if (result < 0) {
            return 0;
        }

        return result;
    }
}