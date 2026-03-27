import java.util.*;

class Solution {
    public String solution(int[] numbers) {        
        
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        
        if(arr[0].equals("0")) return "0";
        
        String res = "";
        for(int i=0; i<arr.length; i++) {          
            res += arr[i];
        }
        return res;
    }
}