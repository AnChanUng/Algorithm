import java.util.*;
/*
    numbers[0]의 비트가 1~2개만 다른 수 중에서 가장 작은 수
*/
class Solution {
    public long[] solution(long[] numbers) {
        long[] res = new long[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            long x = numbers[i];

            if(x % 2 == 0) {
                res[i] = x + 1;
            } else {
                long bit = 1;

                while((x & bit) != 0) {
                    bit <<= 1;
                }

                res[i] = x + bit - (bit >> 1);
            }
        }
        return res;
    }
}