import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        
        int[] res = new int[len];
        
        Arrays.fill(res, -1);
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<len; i++) {
            while(!stack.isEmpty()) {
                int topIndex = stack.peek();
                
                // 더 큰 수를 못찾는 경우
                if(numbers[topIndex] >= numbers[i]) {
                    break;
                }
                
                // 더 큰 수를 찾는 경우
                res[topIndex] = numbers[i];
                stack.pop();
            }
            stack.push(i);
        }
        
        return res;
    }
}