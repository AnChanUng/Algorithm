import java.util.*;
/*
    이익의 10% -> 추천인
    
    예외
    : if (이익의 10%가 1원미만) -> x
    : else 이익의 10% -> 추천인은
    
    알고리즘: DFS
    
    1. seller의 판매량을 hash로 만든다 Hash<seller, amount * 100>
    2. roop
     2.1 enroll[i]의 사람이 hash에 있으면
      2.1.1 판매자의 추천인 있으면 판매량의 10%를 추천인으로 저장
      2.1.2 판매자의 추천이 없으면 판매량 저장
     2.2 enroll[i]의 사람이 hash에 없으면 continue
*/
class Solution { // 판매원이름, 다른 판매원이름, 판매량 집계 데이터의 판매원 이름
    static int[] result;
    static Map<String, Integer> totalMoney; 
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        totalMoney = new HashMap<>();
        result = new int[enroll.length];
        
        for(int i=0; i<enroll.length; i++) {
            if(!totalMoney.containsKey(enroll[i])) {
               totalMoney.put(enroll[i], 0);
            }
        }
        
        for(int i=0; i<seller.length; i++) {
            recommend(seller[i], amount[i] * 100, enroll, referral);
        }
        
        for(int i=0; i<enroll.length; i++) {       
            result[i] = totalMoney.get(enroll[i]);
        }
        
        return result;
    }

    static void recommend(String referralName, int money, String[] enroll, String[] referral) {
        int cost = money / 10;
        totalMoney.put(referralName, totalMoney.get(referralName) + money - cost);
        
        if(cost <= 0) { return; }
        
        for(int i=0; i<enroll.length; i++) {
            if(enroll[i].equals(referralName)) {
                if(referral[i].equals("-")) { return; }
                recommend(referral[i], cost, enroll, referral);
                return;
            }
        }
    }
}