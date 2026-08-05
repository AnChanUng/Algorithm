import java.util.*;
/*
    1. 명령어에 따라 주어진대로 처리
    1.1 | 삽입
    1.2 D 1 큐에 최대값 삭제
    1.3 D -1 큐에 최소값 삭제
    2 큐가 비어있으면 [0, 0] 
    3 큐가 비어있지 않으면 [최대값, 최소값] return
*/
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>(); // 최소값 앞에
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder()); // 최대값 앞에
        for(int i=0; i<operations.length; i++) {
            String str = operations[i];
            String[] st = str.split(" ");
            String order = st[0];
            String number = st[1];
            int num = Integer.parseInt(number);
            
            //System.out.println("i:" + i + " min: " + minpq + " max: " + maxpq);
            // 첫번째 원소가 l이면 두번째 원소 삽입
            if(order.equals("I")) {
                minpq.offer(num);
                maxpq.offer(num);
            } else { // 첫번째 원소가 D고 두번째가 -1이면 
                if(number.equals("-1")) {
                    // 최소값 삭제
                    // maxpq에서도 지워라    
                    maxpq.remove(minpq.poll());
                } else { // 첫번째 원소가 D고 두번째가 1이면
                    // 최대값 삭제
                    // minpq에서도 지워라
                    minpq.remove(maxpq.poll());
                }
            }
        }
        
        int[] res = new int[2];
        if(maxpq.isEmpty()) {
            res[0] = 0;
        } else {
            res[0] = maxpq.poll();
        }
        
        if(minpq.isEmpty()) {
            res[1] = 0;
        } else {
            res[1] = minpq.poll();
        }
        
        return res;
    }
}