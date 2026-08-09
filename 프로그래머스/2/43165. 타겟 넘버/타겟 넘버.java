import java.util.*;
/*
    nubmers의 숫자들을 양수인경우와 음수인경우의 모든 수를 구하고
    합이 target일떄 return;
    0
    알고리즘: DFS, 부분집합
*/
class Solution {
    static int cnt;
    static int[] arr;
    public int solution(int[] numbers, int target) {
        cnt = 0;
        arr = new int[numbers.length];
        dfs(0, numbers, target);
        
        return cnt;
    }
    static void dfs(int depth, int[] numbers, int target) {
        if(depth >= numbers.length) {
            // if(sum == target) {
            //     for(int x : arr) System.out.print(x + " ");
            //     //Sytem.out.println("sum: " + sum + " target: " + target);
            //     System.out.println();
            //     cnt++;
            // }
            int sum = 0;
            for(int i=0; i<arr.length; i++) {
                sum += arr[i];
            }
            if(sum == target) {
                cnt++;
            }
            return;
        }
        
        arr[depth] = numbers[depth];
        dfs(depth+1, numbers, target);
        arr[depth] = -numbers[depth];
        dfs(depth+1, numbers, target);
    }
}