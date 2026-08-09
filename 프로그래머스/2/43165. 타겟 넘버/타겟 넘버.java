import java.util.*;
/*
    nubmers의 숫자들을 양수인경우와 음수인경우의 모든 수를 구하고
    합이 target일떄 return;
    0
    알고리즘: DFS, 부분집합
*/
class Solution {
    static int cnt;
    public int solution(int[] numbers, int target) {
        cnt = 0;
        dfs(0, 0, numbers, target);
        
        return cnt;
    }
    static void dfs(int sum, int depth, int[] numbers, int target) {
        if(depth >= numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        
        dfs(sum + numbers[depth], depth+1, numbers, target);
        dfs(sum - numbers[depth], depth+1, numbers, target);
    }
}