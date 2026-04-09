import java.util.*;
class Solution { // 전체선수들, 완주한 선수들
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<participant.length; i++) {
            if(!map.containsKey(participant[i])) {
                map.put(participant[i], 1);
            } else {
                map.put(participant[i], map.get(participant[i]) + 1);
            }
        }
        
        for(int i=0; i<completion.length; i++) {
            // 사람이 없으면 answer에 저장
            if(map.containsKey(completion[i])) {
                map.put(completion[i], map.get(completion[i]) -1);
            } else {
                answer += completion[i];
            }
        }
        
        for(String x : map.keySet()) {
            if(map.get(x) >= 1) {
                answer += x;
            } 
        }
        
        return answer;
    }
}