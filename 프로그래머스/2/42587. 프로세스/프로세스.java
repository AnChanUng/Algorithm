import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }
        
        int rank = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            boolean flag = false;
            
            for(int[] x : q) {
                if(x[1] > cur[1]) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                q.add(new int[]{cur[0], cur[1]});
            } else {
                if(cur[0] == location) {
                    return rank;
                }
                rank++;
            }
        }
        return rank;
    }
}