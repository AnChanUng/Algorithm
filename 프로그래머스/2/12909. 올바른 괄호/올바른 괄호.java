import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty()) {
                if(ch == '(') {
                    stack.push('(');
                } else {
                    return false;
                }
            } else {
                if(stack.peek() == '(') {
                    if(ch == ')') {
                        stack.pop();
                    } else {
                        stack.push('(');
                    }
                } else { // ')'
                    if(ch == ')') {
                        return false;
                    } else { // '('
                        stack.push('(');
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}