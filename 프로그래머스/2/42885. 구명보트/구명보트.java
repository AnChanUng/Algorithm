import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        while(left <= right) {
            int total = people[left] + people[right];
            if(total <= limit) {
                cnt++;
                left++;
                right--;
            } else {
                cnt++;
                right--;
            }
        }
        
        return cnt;
    }
}