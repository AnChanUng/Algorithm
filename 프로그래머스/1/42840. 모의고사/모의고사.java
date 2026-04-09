import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] arr = new int[3][2];
        
        int[] f1 = {1, 2, 3, 4, 5};
        int[] f2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] f3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 답 개수
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == f1[i%5]) cnt1++;
            if(answers[i] == f2[i%8]) cnt2++;
            if(answers[i] == f3[i%10]) cnt3++;
        }     
        // 1,2,3번 중 답 개수가 가장 큰 사람
        arr[0][0] = cnt1;
        arr[0][1] = 1;
        arr[1][0] = cnt2;
        arr[1][1] = 2;
        arr[2][0] = cnt3;
        arr[2][1] = 3;
        
        int[] res = new int[3];
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));
        
        for(int i=0; i<arr.length-1; i++) {
            res[i] = arr[i][1];
            if(arr[i][0] != arr[i+1][0]) {
                break;
            } else {
                res[i+1] = arr[i+1][1];
            }
        }
        
        if (res[2] == 0 && res[1] == 0) return new int[]{res[0]};
        if (res[2] == 0) return new int[]{res[0], res[1]};
        
        return res;
    }
}