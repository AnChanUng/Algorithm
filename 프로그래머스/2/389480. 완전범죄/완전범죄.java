import java.util.*;
class Solution {
    static int N ;
    static int M ;
    static int[][] info;
    static int[][] dp ; 
    static final int INF = 1_000_000;

    public int solution(int[][] info2, int n, int m) {
        info = info2;
        N = n;
        M = m;
        dp = new int[info2.length][M];
        
        for(int i = 0 ; i < info2.length; i++){
            Arrays.fill(dp[i],-1); //-1로 저장해서 상태표기
        }


        int answer = dfs(0,0);
        
        //dfs(i) < 해당 물건 까지 골랐을때의 상태, 최소값
        //두 경우 모두 끝까지 보내봐야 함
        return answer >= N ? -1 : answer;
    }
    
// 현재 B 흔적이 b일 때
//  i번 물건부터 끝까지 처리해서 필요한 최소 A 흔적
    static int dfs(int itemIndex, int bTrace){

        //~itemIndex 까지 훔쳤을 때의 도둑들의 상태
        if(itemIndex == info.length){
            return 0; //노 물건
        }
        
        //2. 종료조건
        if(dp[itemIndex][bTrace] != -1) 
            return dp[itemIndex][bTrace];

        
        int byB = INF;
        
        //a가 훔칠경우의 a흔적, b가 훔칠경우의 a흔적
        int byA = info[itemIndex][0] + dfs(itemIndex  + 1, bTrace) ;
        
        if(bTrace + info[itemIndex][1] < M){
            byB = dfs(itemIndex  + 1, bTrace + info[itemIndex][1]) ;
        }
    
        dp[itemIndex][bTrace] = Math.min(byA, byB);
    return  dp[itemIndex][bTrace];
    }
}