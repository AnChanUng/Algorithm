import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        int[] arr = new int[progresses.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<progresses.length; i++) {
            // 작업하는데 걸리는 시간 (100이 넘으면 끝)
            int time = 1;
            while(true) {
                int work = progresses[i] + (speeds[i] * time);
                if(work >= 100) break;
                time++;
            }
            arr[i] = time;
        }
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        for(int i=0; i<arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                if(stack.peek() >= arr[i]) {
                   cnt++; 
                } else {
                    stack.push(arr[i]);
                    list.add(cnt);
                    cnt = 1;
                }
            }
        }
        list.add(cnt);
        
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}