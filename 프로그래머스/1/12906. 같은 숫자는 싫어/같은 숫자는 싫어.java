import java.util.*;

public class Solution {
    public int[] solution(int [] arr) {
        
        Stack<Integer> st = new Stack<>();
        st.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(st.peek() != arr[i]) {
                st.add(arr[i]);
            }
        }
        
        // Stack을 배열로 변환
        Integer[] stArray = new Integer[st.size()];
        st.toArray(stArray);
        
        // 배열을 사용하여 값에 접근
        int[] answer = new int[stArray.length];
        for(int i=0; i<st.size(); i++) {
            answer[i] = stArray[i];
        }
        
        return answer;
    }
}