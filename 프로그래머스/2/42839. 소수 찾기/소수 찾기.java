class Solution {
    static boolean[] vis;
    static boolean[] visNum;
    static int cnt = 0;
    public int solution(String numbers) {
        vis = new boolean[numbers.length()];
        visNum = new boolean[10000000];
        dfs(numbers, "", 0);
        return cnt;
    }
    
    static void dfs(String arr, String str, int depth) {
        if(!str.isEmpty()) {
            if(str.charAt(0) == '0') return;
            int num = Integer.parseInt(str);
            if(!visNum[num] && !isPrime(num)) {
                cnt++;
            }
        }
        
        for(int i=0; i<arr.length(); i++) {
            if(!vis[i]) {
                vis[i] = true;
                dfs(arr, str + arr.charAt(i), depth+1);
                vis[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num) {
        if(num <= 1) return true;
        for(int i=2; i<num; i++) {
            if(num % i == 0) {
                return true;
            }
        }
        visNum[num] = true;
        return false;
    }
}