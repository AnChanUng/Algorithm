class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int total = 0;
        // 약수의 개수 구하기
        for(int i=left; i<=right; i++) {
            for(int j=1; j<=i; j++) {
                if(i % j == 0)
                    answer++;
            }
            
            if (answer % 2 == 0) {
                total += i;
            } else {
                total -= i;
            }
            answer = 0;
        }

        return total;
    }
}