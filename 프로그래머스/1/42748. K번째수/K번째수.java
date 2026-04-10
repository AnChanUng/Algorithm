import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // 1.commands[i][0] ~ commands[i][1] 자르기
        // 2.오름차순 정렬 
        // 3.commands[i][2] 번째 수 고르기
        for(int i=0; i<commands.length; i++) {
            int[] res = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(res);
            answer[i] = res[commands[i][2]-1];
        }
        
        return answer;
    }
}