class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    static void dfs(int[] arr, int idx, int sum, int target) {
        if(idx == arr.length) {
            if(sum == target) {
                answer++;
            } 
            return;
        }
        dfs(arr, idx+1, sum+arr[idx], target);
        dfs(arr, idx+1, sum-arr[idx], target);
        
    }
}