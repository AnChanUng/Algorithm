class Solution {
    public int solution(int number, int limit, int power) {
        
        int[] array = new int[number];
        int result = 0;
        for(int i=1; i<=number; i++) {
            int answer = 1;
            for(int j=1; j<=i/2; j++) {
                if(i % j == 0) {
                    answer++;
                }
            }
        
            if (answer <= limit) {
                result += answer;
            } else {
                result += power;
            }
        }
        
        return result;
    }
}