import java.util.HashSet;
import java.util.Iterator;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    public boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }
        
        for(int i=2; i<=(int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다.
        if(!comb.equals("")) {
            numberSet.add(Integer.valueOf(comb));
        }
        // 2. 남은 숫자 중 한개를 더해 새로운 조합을 만든다.
        for(int i=0; i<others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }
    public int solution(String numbers) {
        int count = 0;
        // 1. 모든 숫자의 조합을 만든다.
        recursive("", numbers);
        
        System.out.println(numberSet);
        // 2. 소수의 개수만 센다
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()) {
            int number = it.next();
            if(isPrime(number)) {
                count++;
            }
        }
        
        return count;
    }
}