import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<finished.length; i++) {
            if(finished[i] == false) {
                answer.add(todo_list[i]);
            }
        }
        
        String[] arr = new String[answer.size()];
        
        for(int i=0; i<answer.size(); i++) {
            arr[i] = answer.get(i);
        }
        
        return arr;
    }
}