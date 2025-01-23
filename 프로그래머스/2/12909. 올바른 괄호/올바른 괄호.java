import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == '(') {
                st.push(currentChar);
            } else if (currentChar == ')') {
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();
    }
}