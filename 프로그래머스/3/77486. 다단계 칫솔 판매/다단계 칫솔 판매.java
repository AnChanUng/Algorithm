import java.util.*;
/*
    각 판매원이 득한 이익금을 배열로 출력
  
    알고리즘:
  
    enroll: 판매원 이름
    referral: 각 판매원을 다단계 조직에 참여시킨 다른 판매원의 이름
    seller: 판매원 이름
    amount: 판매 수량 
    
    referral -> enroll (아래로)
    
    1. referral에서 enroll로 가는 인접리스트 생성
    2. seller[i] * amount[i]해서 이익금 배열 생성 
      - Hash(이름, 이익금)
    3. 인접리스트에서 본인의 10%는 레퍼럴에게 넘기고 나머지 본인 저장
      - 10%가 1원미만일 경우는 넘기지 않음
*/
import java.util.*;

class Solution {
    static int[] parent;
    static int[] answer;
    static int n;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        n = enroll.length;

        HashMap<String, Integer> map = new HashMap<>();

        // 판매원 이름 → 인덱스
        for (int i = 0; i < n; i++) {
            map.put(enroll[i], i);
        }

        parent = new int[n];
        answer = new int[n];

        // 판매원 → 추천인 연결
        for (int i = 0; i < n; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = map.get(referral[i]);
            }
        }

        // 모든 판매 기록 처리
        for (int i = 0; i < seller.length; i++) {
            int idx = map.get(seller[i]);
            int money = amount[i] * 100;

            while (idx != -1 && money > 0) {
                int give = money / 10;
                int keep = money - give;

                answer[idx] += keep;

                money = give;
                idx = parent[idx];
            }
        }

        return answer;
    }
}