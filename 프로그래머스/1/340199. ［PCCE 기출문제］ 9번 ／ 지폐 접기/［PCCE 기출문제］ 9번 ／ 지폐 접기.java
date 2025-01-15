class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while((bill[0] > wallet[0]) || (bill[1] > wallet[1])) {
            
            if(bill[0] > bill[1]) {
                bill[0] = bill[0] / 2;
                System.out.println("bill[0]: " + bill[0]);
            } else {
                bill[1] = bill[1] / 2;
                System.out.println("bill[1]: " + bill[1]);
            }
            answer++;
            
            if((bill[0] <= wallet[1]) && (bill[1] <= wallet[0])) {
                break;
            }
            System.out.print("answer: " + answer);
        } 
        
        return answer;
    }
}