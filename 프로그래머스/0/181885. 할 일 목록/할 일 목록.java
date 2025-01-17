import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<finished.length; i++) {
            if(finished[i] == false) {
                answer.add(todo_list[i]);
            }
        }
        
        // List -> String type 배열로 변환
        String[] arr = answer.toArray(new String[0]);
        
        return arr;
    }
}