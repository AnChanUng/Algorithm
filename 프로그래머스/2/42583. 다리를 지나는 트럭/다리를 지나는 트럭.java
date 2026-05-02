import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        // 대기 트럭
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<truck_weights.length; i++) {
            dq.add(truck_weights[i]);
        }
       
        // 다리를 건너는 트럭
        Queue<Integer> truck = new LinkedList<>();
        for(int i=0; i<bridge_length; i++) {
            truck.add(0);
        }
        
        // 다리를 건너는 트럭의 무게의 합
        int truckWeight = 0;
        while(!dq.isEmpty()) {
            time++;
            
            truckWeight -= truck.poll();
            
            int cur = dq.peek();
            
            if(truckWeight + cur <= weight && truck.size() <= bridge_length) {
                truck.add(cur);
                truckWeight += cur;
                dq.poll();
            } else {
                truck.add(0);
            }
        }   
        return time + bridge_length;
    }
}