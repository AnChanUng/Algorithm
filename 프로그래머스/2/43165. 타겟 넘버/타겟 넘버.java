import java.util.*;
/* 합이 target인  */
class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return cnt;
    }
    static void dfs(int[] numbers, int sum, int depth, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }

        dfs(numbers, sum + numbers[depth], depth+1, target);
        dfs(numbers, sum - numbers[depth], depth+1, target);
    }
}