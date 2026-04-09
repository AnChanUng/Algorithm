import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int prev = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = prev;
            }
        }
        
        Arrays.sort(sizes, (a, b) -> {
            if(b[0] != a[0]) return Integer.compare(b[0], a[0]);
            return Integer.compare(b[1], a[1]);
        });
        
        // 가장 큰 숫자 찾기
        int maxNum = 0;
        for(int i=0; i<sizes.length; i++) {
            maxNum = Math.max(sizes[i][1], maxNum);
        }
        
        answer = sizes[0][0] * maxNum;
        
        return answer;
    }
}