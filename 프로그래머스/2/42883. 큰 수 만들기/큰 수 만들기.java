import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
// 앞에서부터 보면서, 스택 top이 현재 문자보다 작고 아직 제거할 수 있으면 pop
        int cnt = 0;
        for(int i=0; i<number.length(); i++) {
            char ch = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < ch && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}