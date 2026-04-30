import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(stack.isEmpty()) {
                list.add(arr[i]);
                stack.push(arr[i]);
            } else {
                if(stack.peek() != arr[i]) {
                    list.add(arr[i]);
                    stack.push(arr[i]);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}