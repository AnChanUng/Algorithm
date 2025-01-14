import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public int[] solution(int k, int[] score) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[score.length];
        
        for(int i=0; i<score.length; i++) {
            if (list.size() < k) {
                list.add(score[i]);
            } else {
                if(Collections.min(list) < score[i]) {
                    list.remove(Collections.min(list));
                    list.add(score[i]);
                }
            }
            arr[i] = Collections.min(list);
        }
        
        return arr;
    }
}