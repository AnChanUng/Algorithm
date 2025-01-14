import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(arr[i-1] != arr[i]) {
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}