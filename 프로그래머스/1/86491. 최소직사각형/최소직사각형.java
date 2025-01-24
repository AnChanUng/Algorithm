import java.util.*;

class Solution {
    public int solution(int[][] sizes) {

        int garo = 0;
        int sero = 0;
        for(int[] arr : sizes) {
            for(int item : arr) {
                garo = Math.max(garo, item);
            }
        }

        for(int i=0; i<sizes.length; i++) {
            if (sero < Math.min(sizes[i][0], sizes[i][1])) {
                sero = Math.min(sizes[i][0], sizes[i][1]);
            }
        }
        
        return garo*sero;
    }
}