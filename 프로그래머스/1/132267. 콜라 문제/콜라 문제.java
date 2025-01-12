class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n / a != 0) {
            answer += b * (n / a);
            n = n % a + b * (n / a);
            System.out.println("n" + n);
            System.out.println("answer: " + answer);
        }
        
        return answer;
    }
}