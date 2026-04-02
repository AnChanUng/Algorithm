import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) { // 선행 스킬 순서, 유저들이 만든 스킬트리 
        // skill의 문자를 번호를 매김
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<skill.length(); i++) {
            char ch = skill.charAt(i);
            map.put(ch, i);
        }
        
        // skill_trees 배열에 문자들을 for문 돌면서 
        // skill의 숫자가 나오면 현재 위치의 숫자 check 
        int cnt = 0;
        for(int i=0; i<skill_trees.length; i++) {
            int cur = 0;
            boolean valid = true;
            for(int j=0; j<skill_trees[i].length(); j++) {
                // 현재 위치 숫자보다 그 다음에 나오는 문자열의 숫자가 더 크면 ok 
                // 끝나면 cnt++
                char c = skill_trees[i].charAt(j);
                //System.out.println("cur: " + cur + " cnt: " + cnt + " map.get(c): " + map.get(c));
                // 처음은 skill의 맨 앞자리여야합니다.
                if(!map.containsKey(c)) continue;
                if(map.get(c) == cur) {
                    cur++;
                } else {
                    valid = false;
                    break;
                } 
            }
            if(valid) cnt++;
        }
        return cnt;
    }
}