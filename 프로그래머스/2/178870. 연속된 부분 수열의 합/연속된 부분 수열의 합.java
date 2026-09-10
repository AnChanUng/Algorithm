import java.util.*;
import java.io.*;
/*
    부분 수열의 합이 k이고 길이가 짧은 수열 구하기
    
    알고리즘: 슬라이딩 윈도우

    배열 인덱스를 늘려가며 값을 더해주고
    값이 k가 될때 break
*/
class Solution {
    static int[] result;
    public int[] solution(int[] sequence, int k) {
        result = new int[2];
        
        int sum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for(int right=0; right<sequence.length; right++) {
            sum += sequence[right];
            
            while(sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k) {
                int len = right - left;
                
                if(len < minLen) {
                    minLen = len;
                    result[0] = left;
                    result[1] = right;
                }
            }
        }
        
        return result;
    }
}