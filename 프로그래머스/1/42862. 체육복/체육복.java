import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 전체 1~n까지 가진 배열 만들기
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i + 1;
        }
        
        // lost 배열에 있는거 삭제하기
        for(int i=0; i<lost.length; i++) {
            arr[lost[i]-1] = 0;
        }
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    arr[lost[i]-1] = -1;
                }
            }
        }

        // arr에 있는거 왼쪽 or 오른쪽이 비어있으면 삽입
        for(int i=0; i<reserve.length; i++) { 
            if(arr[reserve[i]-1] == -1) continue;
            if(reserve[i] >= 2 && arr[reserve[i]-1-1] == 0) {
                arr[reserve[i]-1-1] = reserve[i]-1;
            } else if (reserve[i] <= n-1 && arr[reserve[i]] == 0) {
                arr[reserve[i]] = reserve[i]+1;
            }
        }
        
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                cnt++;
            }
        }
        
        return cnt;
    }
}