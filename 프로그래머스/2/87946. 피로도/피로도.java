import java.util.*;
/* 순열 백트래킹 dfs */
class Solution {
    static boolean[] vis;
    static int[][] dungeons;
    static int maxCnt;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        vis = new boolean[dungeons.length];
        maxCnt = 0;
        
        dfs(k, 0);
        return maxCnt;
    }
    
    static void dfs(int k, int depth) {
        maxCnt = Math.max(maxCnt, depth);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!vis[i] && dungeons[i][0] <= k) {
                vis[i] = true;
                dfs(k - dungeons[i][1], depth+1);
                vis[i] = false;
            }
        }
    }
}

// class Solution {
//     public static boolean[] visited;
//     //public static int answer;
//     public static int maxNum;
//     public int solution(int k, int[][] dungeons) {
//         //int answer = 0;
//         maxNum = 0;
//         visited = new boolean[dungeons.length];
//         generate(k,dungeons, 0);
//         return maxNum;
//     }
//     public void generate(int k, int[][] dungeons, int depth) {
//         maxNum = Math.max(maxNum, depth);
        
//         for(int i=0;i<dungeons.length;i++) {
//             if(visited[i]==true) continue; 
//             if(dungeons[i][0] > k) continue;
            
//             visited[i]=true;
//             generate(k-=dungeons[i][1],dungeons, depth+1);
//             //answer++;
//             visited[i]=false;
            
//             //generate(k-=dungeons[i][1],dungeons);
//         }
//     }
// }