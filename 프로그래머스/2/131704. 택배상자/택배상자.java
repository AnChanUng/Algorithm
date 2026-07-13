import java.util.*;
/*
    트럭: []
    보조: [1]
    
    트럭: []
    보조: [1,2]
    
    트럭: []
    보조: [1,2,3]
    
    트럭: [4]
    보조: [1,2,3]
    
    트럭: [4,3] 
    보조: [1,2]
    
    트럭에 실을 수 있는 개수
    
    트럭: arraylist
    보조: stack
    
    1. 배열에 하나씩 꺼내면서 order이 아니면 보조 벨트에 넣는다.
    2. order 배열의 원하는 숫자와 order or stack의 숫자가 일치하면 트럭에 싣는다.
    3. 더이상 트럭에 싣을 수 없으면 트럭의 크기를 출력한다.
*/
class Solution {
    public int solution(int[] order) {
        int orderSize = order.length;
        
        int[] arr = new int[orderSize];
        for(int i=1; i<=orderSize; i++) {
            arr[i-1] = i;
        }
        
        List<Integer> truck = new ArrayList<>(); // 트럭
        Stack<Integer> stack = new Stack<>(); // 보조
        
        int arrIdx = 0;
        int orderIdx = 0;
        while(orderIdx < orderSize) {
            if(!stack.isEmpty() && order[orderIdx] == stack.peek()) {
                truck.add(stack.pop());
                orderIdx++;
            } else if(arrIdx < orderSize && order[orderIdx] == arr[arrIdx]) {
                truck.add(arr[arrIdx]);
                orderIdx++;
                arrIdx++;
            } else if (arrIdx < orderSize) { 
                stack.add(arr[arrIdx]);
                arrIdx++;
            } else {
                break;
            }
        }
        return truck.size();
    }
}