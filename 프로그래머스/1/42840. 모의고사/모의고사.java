import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] number1 = {1, 2, 3, 4, 5};
        int[] number2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] number3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for(int i=0; i<answers.length; i++) {
            if(number1[i%number1.length] == answers[i]) { cnt1++; }
            if(number2[i%number2.length] == answers[i]) { cnt2++; }
            if(number3[i%number3.length] == answers[i]) { cnt3++; }
        }
        
        int maxCount = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        List<Integer> result = new ArrayList<>();
        if (cnt1 == maxCount) result.add(1);
        if (cnt2 == maxCount) result.add(2);
        if (cnt3 == maxCount) result.add(3);
        
        int[] resultArray = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}