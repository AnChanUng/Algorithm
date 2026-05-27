import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        
        int[] res = new int[set.size()];
        int i = 0;
        for(int x : set) {
            res[i++] = x;
        }
        
        Arrays.sort(res);
        
        return res;
    }
}