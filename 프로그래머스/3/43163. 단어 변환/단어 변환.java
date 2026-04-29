import java.util.*;
/*
    begin의 알파벳이 한번에 하나씩만 바꿔서 target이 될 때 걸리는 최소 횟수
    
    알고리즘: dfs (순열, 백트래킹)
    
    1.1 words 배열에서 하나의 단어만 다른 단어를 찾아서 변환한다.
    1.2 변환할 때 마다 cnt++
    1.3 변환하다가 target 단어와 일치하면 종료한다.
    1.4 cnt의 최소 값을 구한다.
*/  
class Solution {
    static boolean[] vis;
    static int minDepth = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        vis = new boolean[words.length];
        dfs(begin, target, words, 0);
        if(minDepth == Integer.MAX_VALUE) {
            minDepth = 0;
        }
        return minDepth;
    }
    static void dfs(String str, String target, String[] words, int depth) {
        if(str.equals(target)) {
            minDepth = Math.min(minDepth, depth);
            return;
        }
        if(depth >= words.length) {
            return;
        }
        for(int i=0; i<words.length; i++) {
            // str의 문자와 words[i]의 문자가 1개만 뺴고 같을 때
            int diffCnt = 0;
            for(int j=0; j<words[i].length(); j++) {
                char ch1 = str.charAt(j);                
                char ch2 = words[i].charAt(j);
                if(ch1 != ch2) {
                    diffCnt++;
                }
            }
            
            if(!vis[i]) {
                if(diffCnt == 1) {
                    vis[i] = true;
                    dfs(words[i], target, words, depth+1);
                    vis[i] = false;
                }
            }
        }        
    }
}