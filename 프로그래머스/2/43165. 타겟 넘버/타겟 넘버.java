import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    static void dfs(int[] arr, int depth, int sum, int target) {
        if(depth == arr.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        dfs(arr, depth+1, sum+arr[depth], target); 
        dfs(arr, depth+1, sum-arr[depth], target);  
    }
}